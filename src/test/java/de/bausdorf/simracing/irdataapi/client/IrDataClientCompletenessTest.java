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

import com.fasterxml.jackson.databind.JsonNode;
import de.bausdorf.simracing.irdataapi.client.impl.IrDataClientImpl;
import de.bausdorf.simracing.irdataapi.config.ConfigProperties;
import de.bausdorf.simracing.irdataapi.model.*;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.internal.bytebuddy.dynamic.DynamicType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = {IrDataClientCompletenessTest.class})
@EnableConfigurationProperties(value = ConfigProperties.class)
@TestPropertySource("classpath:application-test.properties")
@Slf4j
class IrDataClientCompletenessTest {

    public static final long CUST_ID = 229120L;
    @Autowired
    ConfigProperties config;

    IrDataClientImpl dataClient = new IrDataClientImpl();


    @Test
    void testAllEndpointsSupported() {
        authenticate();
        JsonNode rootNode = dataClient.getApiDocs();
        List<JsonNode> linkNodes = rootNode.findValues("link");

        DataApiConstants.SUPPORTED_ENDPOINTS
                .forEach(url -> {
                    Optional<JsonNode> matchingNode = Optional.empty();
                    for(JsonNode node : linkNodes) {
                        if (node.asText().equalsIgnoreCase(url)) {
                            matchingNode = Optional.of(node);
                            break;
                        }
                    }
                    matchingNode.ifPresent(linkNodes::remove);
                });

        linkNodes.forEach(node -> log.warn(node.asText()));
        assertTrue(linkNodes.isEmpty(), () -> "Number of unsupported endpoints: " + linkNodes.size());
    }

    private void authenticate() {
        if (!dataClient.isAuthenticated()) {
            log.info("Authenticate with user {}", config.getUser());
            LoginRequestDto dto = LoginRequestDto.builder()
                    .email(config.getUser())
                    .password(config.getPassword())
                    .build();
            dataClient.setHashPassword(config.getHashPassword());
            AuthResponseDto authResponseDto = dataClient.authenticate(dto);
            dataClient.setLogResponseJson(config.getLogResponseJson());
            log.info(authResponseDto.toString());
        }
    }
}
