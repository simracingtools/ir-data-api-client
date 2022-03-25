package de.bausdorf.simracing.irdataapi.client.impl;

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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import de.bausdorf.simracing.irdataapi.client.AuthorizationException;
import de.bausdorf.simracing.irdataapi.client.DataApiConstants;
import de.bausdorf.simracing.irdataapi.client.DataApiException;
import de.bausdorf.simracing.irdataapi.client.IrDataClient;
import de.bausdorf.simracing.irdataapi.model.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class IrDataClientImpl implements IrDataClient {

    public static final String RETURNED_NULL_BODY = " returned null body";
    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;

    private AuthResponseDto authResponse;
    private boolean logResponseJson;
    private final Logger jsonLogger = LoggerFactory.getLogger("JsonResponse");

    public IrDataClientImpl() {
        restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new StatefulRestTemplateInterceptor());
        mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());
        authResponse = null;
    }

    @Override
    public void setLogResponseJson(@NonNull Boolean logResponse) {
        this.logResponseJson = logResponse;
    }

    @Override
    public boolean isLogResponseJson() {
        return logResponseJson;
    }

    @Override
    public AuthResponseDto authenticate(@NonNull LoginRequestDto requestDto) {
        ResponseEntity<String> response = restTemplate.postForEntity(DataApiConstants.AUTH_URL, requestDto, String.class);
        try {
            String responseBody = response.getBody();
            if (responseBody != null) {
                authResponse = mapper.readValue(responseBody, AuthResponseDto.class);
                if(authResponse.getAuthcode().equalsIgnoreCase("0")) {
                    throw new AuthorizationException(requestDto.getEmail() + " not authorized");
                }
                log.info("iRacing DataApi authenticated for custId: {}", authResponse.getCustId());
            } else {
                throw new DataApiException("Null body when authenticating, status code " + response.getStatusCode());
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return authResponse;
    }

    @Override
    public boolean isAuthenticated() {
        return authResponse != null;
    }

    @Override
    public MembersInfoDto getMembersInfo(@NonNull List<Long> custIds) {
        var uri = new StringBuilder(DataApiConstants.GET_MEMBERS_URL);
        uri.append("?cust_ids=");
        for(var i = 0; i < custIds.size(); i++) {
            uri.append(custIds.get(i));
            if(i < custIds.size() - 1) {
                uri.append(',');
            }
        }

        try {
            LinkResponseDto linkResponse = getLinkResponse(uri.toString());

            if (linkResponse!= null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<MembersInfoDto>(){});
            }
            throw new DataApiException(DataApiConstants.GET_MEMBERS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public MemberSummaryDto getMemberSummary(@NonNull Long custId) {
        try {
            LinkResponseDto linkResponse = getLinkResponse(uriWithCustIdParameter(DataApiConstants.GET_MEMBER_SUMMARY_URL, custId));

            if (linkResponse!= null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<MemberSummaryDto>(){});
            }
            throw new DataApiException(DataApiConstants.GET_MEMBER_SUMMARY_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public MemberYearlyDto getMemberStatsYearly(@NonNull Long custId) {
        try {
            LinkResponseDto linkResponse = getLinkResponse(uriWithCustIdParameter(DataApiConstants.GET_MEMBER_YEARLY_URL, custId));

            if (linkResponse!= null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<MemberYearlyDto>(){});
            }
            throw new DataApiException(DataApiConstants.GET_MEMBER_YEARLY_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public MemberCareerDto getMemberCareer(@NonNull Long custId) {
        try {
            LinkResponseDto linkResponse = getLinkResponse(uriWithCustIdParameter(DataApiConstants.GET_MEMBER_CAREER_URL, custId));

            if (linkResponse!= null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<MemberCareerDto>(){});
            }
            throw new DataApiException(DataApiConstants.GET_MEMBER_CAREER_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public MemberRecentRacesDto getMemberRecentRaces(@NonNull Long custId) {
        try {
            LinkResponseDto linkResponse = getLinkResponse(uriWithCustIdParameter(DataApiConstants.GET_MEMBER_RECENT_RACES_URL, custId));

            if (linkResponse!= null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<MemberRecentRacesDto>(){});
            }
            throw new DataApiException(DataApiConstants.GET_MEMBER_RECENT_RACES_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public CarInfoDto[] getCarInfo() {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_CARS_URL);
            if(linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<CarInfoDto[]>() {});
            }
            throw new DataApiException(DataApiConstants.GET_CARS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public CarClassDto[] getCarClasses() {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_CAR_CLASSES_URL);
            if(linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<CarClassDto[]>() {});
            }
            throw new DataApiException(DataApiConstants.GET_CAR_CLASSES_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public DivisionDto[] getDivisions() {
        try {
            return getStructuredData(DataApiConstants.GET_DIVISIONS_URL, new TypeReference<DivisionDto[]>() {});
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public Map<Long, CarAssetDto> getCarAssets() {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_CAR_ASSETS_URL);
            if(linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<HashMap<Long, CarAssetDto>>() {});
            }
            throw new DataApiException(DataApiConstants.GET_CAR_ASSETS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public Map<Long, TrackAssetDto> getTrackAssets() {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_TRACK_ASSETS_URL);
            if(linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<HashMap<Long, TrackAssetDto>>() {});
            }
            throw new DataApiException(DataApiConstants.GET_TRACK_ASSETS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public LeagueInfoDto getLeagueInfo(long leagueId) {
        try{
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_LEAGUE_URL + "?league_id=" + leagueId);
            if(linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<LeagueInfoDto>() {});
            }
            throw new DataApiException(DataApiConstants.GET_LEAGUE_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public SeasonDto[] getSeasonInfo(Boolean includeSeries) {
        try{
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_SEASONS_URL + "?include_series=" + includeSeries.toString());
            if(linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<SeasonDto[]>() {});
            }
            throw new DataApiException(DataApiConstants.GET_SEASONS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public TrackInfoDto[] getTrackInfos() {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_TRACKS_URL);
            if(linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<TrackInfoDto[]>() {});
            }
            throw new DataApiException(DataApiConstants.GET_TRACKS_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    @Override
    public LicenseGroupDto[] getLicenseGroups() {
        try {
            LinkResponseDto linkResponse = getLinkResponse(DataApiConstants.GET_LICENSES_URL);
            if(linkResponse != null) {
                return getStructuredData(linkResponse.getLink(), new TypeReference<LicenseGroupDto[]>() {});
            }
            throw new DataApiException(DataApiConstants.GET_LICENSES_URL + RETURNED_NULL_BODY);
        } catch (IOException e) {
            throw new DataApiException(e);
        }
    }

    private LinkResponseDto getLinkResponse(@NonNull String uri) throws IOException {
        String response = restTemplate.getForEntity(URI.create(uri), String.class).getBody();
        if(response != null && response.contains("Unauthorized")) {
            authResponse = null;
            throw new AuthorizationException("No longer authorized, call authenticate()");
        } else if (response == null) {
            throw new DataApiException("Null body from " + uri);
        }

        return mapper.readValue(response, LinkResponseDto.class);
    }

    private <T> T getStructuredData(@NonNull String link, @NonNull TypeReference<T> targetType) throws IOException {
        var uriBuilder = UriComponentsBuilder.fromUriString(link);
        ResponseEntity<String> infoResponse = restTemplate.getForEntity(uriBuilder.build(true).toUri(), String.class);
        String infoResponseBody = infoResponse.getBody();
        if(isLogResponseJson()) {
            jsonLogger.info("{}: {}", targetType.getType().getTypeName(), infoResponseBody);
        }
        if (infoResponseBody != null) {
            return mapper.readValue(infoResponseBody, targetType);
        } else {
            throw new DataApiException("Null body from AWS, status code " + infoResponse.getStatusCode());
        }
    }

    private String uriWithCustIdParameter(@NonNull String baseUri, @NonNull Long custId) {
        var stringBuilder = new StringBuilder(baseUri);
        stringBuilder.append("?cust_id=").append(custId);
        return stringBuilder.toString();
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
