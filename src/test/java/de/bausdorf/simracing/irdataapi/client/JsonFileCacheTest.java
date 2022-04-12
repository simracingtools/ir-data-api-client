package de.bausdorf.simracing.irdataapi.client;

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

    IrDataClient dataClient = new IrDataClientImpl();

    @Test
    void initializeSingleObjectCache() {
        JsonFileCache<LeagueInfoDto> leagueCache = new JsonFileCache<>(".cache", "fbp_league");
        authenticate();
        leagueCache.setCachedData(dataClient.getLeagueInfo(FBP_LEAGUE_ID));
        assertNotEquals(0L, leagueCache.cacheLastModified());
        assertTrue(leagueCache.cacheExists());

        JsonFileCache<LeagueInfoDto> cacheFromFile = new JsonFileCache<>(".cache", "fbp_league");
        assertTrue(cacheFromFile.cacheExists());
        assertNotEquals(0L, cacheFromFile.cacheLastModified());
        assertNotNull(cacheFromFile.getCachedData());
        assertInstanceOf(LeagueInfoDto.class, cacheFromFile.getCachedData());
    }

    @Test
    void initializeListObjectCache() {
        JsonFileCache<List<LeagueMemberDto>> leagueCache = new JsonFileCache<>(".cache", "fbp_league_roster");
        authenticate();
        leagueCache.setCachedData(Arrays.asList(dataClient.getLeagueInfo(FBP_LEAGUE_ID).getRoster()));
        assertNotEquals(0L, leagueCache.cacheLastModified());
        assertTrue(leagueCache.cacheExists());

        JsonFileCache<List<LeagueMemberDto>> cacheFromFile = new JsonFileCache<>(".cache", "fbp_league_roster");
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
