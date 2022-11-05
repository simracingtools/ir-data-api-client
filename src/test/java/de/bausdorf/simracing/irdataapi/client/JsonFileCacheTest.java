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
import de.bausdorf.simracing.irdataapi.model.AuthResponseDto;
import de.bausdorf.simracing.irdataapi.model.LeagueInfoDto;
import de.bausdorf.simracing.irdataapi.model.LeagueMemberDto;
import de.bausdorf.simracing.irdataapi.model.LoginRequestDto;
import de.bausdorf.simracing.irdataapi.tools.JsonFileCache;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {IrDataClientTest.class})
@EnableConfigurationProperties(value = ConfigProperties.class)
@TestPropertySource("classpath:application-test.properties")
@Slf4j
class JsonFileCacheTest {

    public static final long FBP_LEAGUE_ID = 3693L;

    @Autowired
    ConfigProperties config;

    static final IrDataClient dataClient = new IrDataClientImpl();

    @Test
    void initializeSingleObjectCache() {
        authenticate();
        JsonFileCache<LeagueInfoDto> leagueCache = new JsonFileCache<>(config.getCacheDirectory(), "fbp_league");
        leagueCache.setCachedData(dataClient.getLeagueInfo(FBP_LEAGUE_ID));
        assertNotEquals(0L, leagueCache.cacheLastModified());
        assertTrue(leagueCache.cacheExists());

        JsonFileCache<LeagueInfoDto> cacheFromFile = new JsonFileCache<>(config.getCacheDirectory(), "fbp_league");
        assertTrue(cacheFromFile.cacheExists());
        assertNotEquals(0L, cacheFromFile.cacheLastModified());
        assertNotNull(cacheFromFile.getCachedData());
        assertInstanceOf(LeagueInfoDto.class, cacheFromFile.getCachedData());
    }

    @Test
    void initializeListObjectCache() {
        authenticate();
        JsonFileCache<List<LeagueMemberDto>> leagueCache = new JsonFileCache<>(config.getCacheDirectory(), "fbp_league_roster");
        leagueCache.setCachedData(Arrays.asList(dataClient.getLeagueInfo(FBP_LEAGUE_ID).getRoster()));
        assertNotEquals(0L, leagueCache.cacheLastModified());
        assertTrue(leagueCache.cacheExists());

        JsonFileCache<List<LeagueMemberDto>> cacheFromFile = new JsonFileCache<>(config.getCacheDirectory(), "fbp_league_roster");
        assertTrue(cacheFromFile.cacheExists());
        assertNotEquals(0L, cacheFromFile.cacheLastModified());
        List<LeagueMemberDto> roster = cacheFromFile.getCachedData();
        assertNotEquals(0L, roster.size());
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
