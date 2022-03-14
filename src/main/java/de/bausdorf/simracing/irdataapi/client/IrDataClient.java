package de.bausdorf.simracing.irdataapi.client;

/*-
 * #%L
 * iRDataAPIClient
 * %%
 * Copyright (C) 2022 bausdorf engineering
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import de.bausdorf.simracing.irdataapi.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@Slf4j
public class IrDataClient {

    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;

    private AuthResponseDto authResponse;

    public IrDataClient() {
        restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new StatefulRestTemplateInterceptor());
        mapper = new ObjectMapper();
        authResponse = null;
    }

    public AuthResponseDto authenticate(LoginRequestDto requestDto) {
        ResponseEntity<String> response = restTemplate.postForEntity(DataApiConstants.AUTH_URL, requestDto, String.class);
        try {
            String responseBody = response.getBody();
            if (responseBody != null) {
                authResponse = mapper.readValue(responseBody, AuthResponseDto.class);
                log.info("iRacing DataApi authenticated for custId: {}", authResponse.getCustId());
            } else {
                throw new DataApiException("Null body when authenticating, status code " + response.getStatusCode());
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return authResponse;
    }

    public boolean isAuthenticated() {
        return authResponse != null;
    }

    public MembersInfoDto getMembersInfo(List<String> custIds) {
        if(authResponse == null) {
            throw new DataApiException("Client not authenticated");
        }
        var uri = new StringBuilder(DataApiConstants.GET_MEMBERS_URL);
        uri.append("?cust_ids=");
        for(var i = 0; i < custIds.size(); i++) {
            uri.append(custIds.get(i));
            if(i < custIds.size() - 1) {
                uri.append(',');
            }
        }

        try {
            LinkResponseDto body = getLinkResponse(uri.toString());

            if (body!= null) {
                return getAwsData(body, MembersInfoDto.class);
            }
            throw new DataApiException(DataApiConstants.GET_MEMBERS_URL + " returned null body");
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    public CarInfoDto[] getCarInfo() {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_CARS_URL);
            if(linkResponse != null) {
                return getAwsData(linkResponse, CarInfoDto[].class);
            }
            throw new DataApiException(DataApiConstants.GET_CARS_URL + " returned null body");
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    private LinkResponseDto getLinkResponse(String uri) throws IOException {
        String response = restTemplate.getForEntity(URI.create(uri), String.class).getBody();
        if(response != null && response.contains("Unauthorized")) {
            authResponse = null;
            throw new AuthorizationException("No longer authorized, call authenticate()");
        } else if (response == null) {
            throw new DataApiException("Null body from " + uri);
        }

        return mapper.readValue(response, LinkResponseDto.class);
    }

    private <T> T getAwsData(@NonNull LinkResponseDto linkResponse, @NonNull Class<T> targetType) throws IOException {
        String awsLink = linkResponse.getLink();
        var uriBuilder = UriComponentsBuilder.fromUriString(awsLink);
        ResponseEntity<String> infoResponse = restTemplate.getForEntity(uriBuilder.build(true).toUri(), String.class);
        String infoResponseBody = infoResponse.getBody();
        if (infoResponseBody != null) {
            return mapper.readValue(infoResponseBody, targetType);
        } else {
            throw new DataApiException("Null body from AWS, status code " + infoResponse.getStatusCode());
        }
    }

    public static class StatefulRestTemplateInterceptor implements ClientHttpRequestInterceptor {
        private List<String> cookie;

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            if (cookie != null) {
                request.getHeaders().addAll(HttpHeaders.COOKIE, cookie);
            }
            HttpHeaders requestHeaders = request.getHeaders();
            log.debug("REQUEST-HEADERS");
            requestHeaders.forEach((k, v) -> log.debug("{}={}", k, v));
            log.debug("Request-Uri: {}", request.getURI());
            ClientHttpResponse response = execution.execute(request, body);

            if (cookie == null) {
                cookie = response.getHeaders().get(HttpHeaders.SET_COOKIE);
            }
            log.debug("RESPONSE-HEADERS");
            HttpHeaders responseHeaders = response.getHeaders();
            responseHeaders.forEach((k, v) -> log.debug("{}={}", k, v));
            return response;
        }
    }
}
