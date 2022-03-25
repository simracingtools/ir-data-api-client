package de.bausdorf.simracing.irdataapi.client;

import de.bausdorf.simracing.irdataapi.model.CarClassKey;
import de.bausdorf.simracing.irdataapi.model.CarInfoDto;
import de.bausdorf.simracing.irdataapi.model.TrackInfoDto;
import de.bausdorf.simracing.irdataapi.tools.StockDataCache;
import de.bausdorf.simracing.irdataapi.tools.StockDataTools;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;

@Slf4j
class StockDataToolsTest {

    static final StockDataCache dataCache = new StockDataCache(".cache");

    @BeforeAll
    @SneakyThrows
    static void fetchCacheData() {
        dataCache.fetchFromCache();
    }

    @Test
    void testGetTrackConfigMap() {
        Map<Long, List<TrackInfoDto>> trackMap = StockDataTools.trackConfigurationMap(dataCache.getTracks());
        assertFalse(trackMap.isEmpty());

        trackMap.entrySet().stream().forEach(e -> {
            log.info("SKU: {}", e.getKey());
            e.getValue().stream().forEach(t -> log.info("{}: {} - {}", t.getTrackId(), t.getTrackName(), t.getConfigName()));
        });
    }

    @Test
    void testGetCarClassMap() {
        Map<CarClassKey, List<CarInfoDto>> carClassMap = StockDataTools.carClassMap(dataCache.getCarClasses(), dataCache.getCars());
        assertFalse(carClassMap.isEmpty());

        carClassMap.entrySet().stream().forEach(e -> {
            log.info("Class {}: {}", e.getKey().getCarClassId(), e.getKey().getName());
            e.getValue().stream().forEach(c -> log.info("    Car {}: {}", c.getCarId(), c.getCarName()));
        });
    }
}
