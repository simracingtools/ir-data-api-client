package de.bausdorf.simracing.irdataapi.client;

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
    public static final long CUST_ID = 229120L;
    @Autowired
    ConfigProperties config;

    IrDataClient dataClient = new IrDataClientImpl();

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
        StockDataCache cache = new StockDataCache(".cache");
        try {
            cache.fetchFromService(dataClient);
            fail("Exception expected");
        } catch (AuthorizationException e) {
            assertFalse(cache.isInitialized());
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
