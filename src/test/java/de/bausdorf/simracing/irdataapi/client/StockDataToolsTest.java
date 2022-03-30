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

import de.bausdorf.simracing.irdataapi.model.CarClassKey;
import de.bausdorf.simracing.irdataapi.model.CarInfoDto;
import de.bausdorf.simracing.irdataapi.model.TrackInfoDto;
import de.bausdorf.simracing.irdataapi.tools.StockDataCache;
import de.bausdorf.simracing.irdataapi.tools.StockDataTools;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;

@Slf4j
class StockDataToolsTest {

    static final StockDataCache dataCache = new StockDataCache(".cache");

    @BeforeAll
    static void fetchCacheData() {
        try {
            dataCache.fetchFromCache();
        } catch (IOException e) {
            log.warn(e.getMessage());
        }
    }

    @Test
    void testGetTrackConfigMap() {
        Map<Long, List<TrackInfoDto>> trackMap = StockDataTools.trackConfigurationMap(dataCache.getTracks());
        assertFalse(trackMap.isEmpty());

        trackMap.entrySet().forEach(e -> {
            log.info("SKU: {}", e.getKey());
            e.getValue().forEach(t -> log.info("{}: {} - {}", t.getTrackId(), t.getTrackName(), t.getConfigName()));
        });
    }

    @Test
    void testGetCarClassMap() {
        Map<CarClassKey, List<CarInfoDto>> carClassMap = StockDataTools.carClassMap(dataCache.getCarClasses(), dataCache.getCars());
        assertFalse(carClassMap.isEmpty());

        carClassMap.entrySet().forEach(e -> {
            log.info("Class {}: {}", e.getKey().getCarClassId(), e.getKey().getName());
            e.getValue().forEach(c -> log.info("    Car {}: {}", c.getCarId(), c.getCarName()));
        });
    }

    @Test
    void testCarsInClasses() {
        List<Long> classIds = Lists.list(3190L, 2523L);
        List<CarInfoDto> cars = StockDataTools.carsInClasses(classIds, dataCache.getCarClasses(), dataCache.getCars());
        assertFalse(cars.isEmpty());

        cars.forEach(car -> log.info("{}: {}", car.getCarId(), car.getCarName()));
    }
}
