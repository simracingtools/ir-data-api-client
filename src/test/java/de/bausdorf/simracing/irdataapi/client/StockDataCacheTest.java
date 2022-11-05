package de.bausdorf.simracing.irdataapi.client;

/*-
 * #%L
 * de.bausdorf.simracing:ir-data-api-client
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

import de.bausdorf.simracing.irdataapi.client.impl.IrDataClientImpl;
import de.bausdorf.simracing.irdataapi.config.ConfigProperties;
import de.bausdorf.simracing.irdataapi.model.*;
import de.bausdorf.simracing.irdataapi.tools.StockDataCache;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {IrDataClientTest.class})
@EnableConfigurationProperties(value = ConfigProperties.class)
@TestPropertySource("classpath:application-test.properties")
@Slf4j
class StockDataCacheTest {
    @Autowired
    ConfigProperties config;

    static final IrDataClient dataClient = new IrDataClientImpl();

    @Test
    void initializeFromNonexistentCache() {
        StockDataCache cache = new StockDataCache("/foo/bar");
        assertFalse(cache.isInitialized());
    }

    @Test
    void initializeFromExistentCache() {
        StockDataCache cache = new StockDataCache("src/test/resources");
        assertTrue(cache.isInitialized());
    }

    @Test
    void initializeFromUnauthorizedDataClient() {
        try {
            LoginRequestDto dto = LoginRequestDto.builder()
                    .email("kirk@starfleet.com")
                    .password("spock")
                    .build();
            dataClient.authenticate(dto);
        } catch (AuthorizationException e) {
            log.info("Valid login removed");
        }

        StockDataCache cache = new StockDataCache(".cache");
        try {
            cache.fetchFromService(dataClient);
            fail("Exception expected");
        } catch (AuthorizationException e) {
            log.info(e.getMessage());
        }
    }

    @Test
    void initializeFromAuthorizedDataClient() {
        StockDataCache cache = new StockDataCache(".cache");
        authenticate();
        cache.fetchFromService(dataClient);
        assertTrue(cache.isInitialized());
        assertTrue(cache.cacheExists());
    }

    private void authenticate() {
        if (!dataClient.isAuthenticated()) {
            LoginRequestDto dto = LoginRequestDto.builder()
                    .email(config.getUser())
                    .password(config.getPassword())
                    .build();
            AuthResponseDto authResponseDto = dataClient.authenticate(dto);
            dataClient.setLogResponseJson(config.getLogResponseJson());
            log.info(authResponseDto.toString());
        }
    }
}
