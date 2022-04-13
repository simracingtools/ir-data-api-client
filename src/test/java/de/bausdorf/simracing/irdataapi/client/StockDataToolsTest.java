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
import de.bausdorf.simracing.irdataapi.tools.*;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        trackMap.forEach((key, value) -> {
            log.info("SKU: {}", key);
            value.forEach(t -> log.info("{}: {} - {}", t.getTrackId(), t.getTrackName(), t.getConfigName()));
        });
    }

    @Test
    void testGetCarClassMap() {
        Map<CarClassKey, List<CarInfoDto>> carClassMap = StockDataTools.carClassMap(dataCache.getCarClasses(), dataCache.getCars());
        assertFalse(carClassMap.isEmpty());

        carClassMap.forEach((key, value) -> {
            log.info("Class {}: {}", key.getCarClassId(), key.getName());
            value.forEach(c -> log.info("    Car {}: {}", c.getCarId(), c.getCarName()));
        });
    }

    @Test
    void testCarsInClasses() {
        List<Long> classIds = Lists.list(3190L, 2523L);
        List<CarInfoDto> cars = StockDataTools.carsInClasses(classIds, dataCache.getCarClasses(), dataCache.getCars());
        assertFalse(cars.isEmpty());

        cars.forEach(car -> log.info("{}: {}", car.getCarId(), car.getCarName()));
    }

    @Test
    void testFetchCarTypes() {
        NavigableSet<String> carTypes = StockDataTools.fetchAvailableCarTypes(dataCache.getCars(), MainCarType.ROAD);
        assertFalse(carTypes.isEmpty());

        carTypes.stream().sorted().forEach(log::info);
    }

    @Test
    void testCarsByCategory() {
        List<CarInfoDto> carInfosWithLegacy = StockDataTools.carsByCategory(dataCache.getCars(), CarCategoryType.ROAD, false);
        assertFalse(carInfosWithLegacy.isEmpty());

        log.info("Category {}:", CarCategoryType.ROAD.name());
        carInfosWithLegacy.forEach(car -> log.info(car.getCarName()));
    }

    @Test
    void testCarsByType() {
        List<CarInfoDto> carInfosWithLegacy = StockDataTools.carsByType(dataCache.getCars(), "road", true);
        assertFalse(carInfosWithLegacy.isEmpty());

        log.info("\nAll cars");
        carInfosWithLegacy.forEach(car -> log.info(car.getCarName()));

        List<CarInfoDto> carInfosWithOutLegacy = StockDataTools.carsByType(dataCache.getCars(), "road", false);
        assertFalse(carInfosWithOutLegacy.isEmpty());
        assertTrue(carInfosWithOutLegacy.size() < carInfosWithLegacy.size());

        log.info("\nNon-legacy cars");
        carInfosWithOutLegacy.forEach(car -> log.info(car.getCarName()));

        Constants.CAR_SUBTYPES
                .forEach(subtype -> {
                    log.info("\n{}\n", subtype);
                    StockDataTools.carsByType(dataCache.getCars(), subtype, false)
                            .forEach(car -> log.info(car.getCarName()));
                });
    }

    @Test
    void testCarsByTypes() {
        List<String> carTypes = List.of(Constants.GT3, Constants.GT4, Constants.TCR, "supercup");
        List<CarInfoDto> carInfos = StockDataTools.carsByType(dataCache.getCars(), carTypes, true);
        assertFalse(carInfos.isEmpty());

        carInfos.forEach(car -> log.info(car.getCarName()));
    }

    @Test
    void testTracksByType() {
        List<TrackInfoDto> infosWithLegacy = StockDataTools.tracksByType(dataCache.getTracks(), TrackType.ROAD, true);
        assertFalse(infosWithLegacy.isEmpty());

        log.info("All tracks");
        infosWithLegacy.forEach(track -> log.info("{} - {}",track.getTrackName(), track.getConfigName()));

        List<TrackInfoDto> infosWithOutLegacy = StockDataTools.tracksByType(dataCache.getTracks(), TrackType.ROAD, false);
        assertFalse(infosWithOutLegacy.isEmpty());
        assertTrue(infosWithOutLegacy.size() < infosWithLegacy.size());

        log.info("\nNon-legacy tracks");
        infosWithOutLegacy.forEach(track -> log.info("{} - {}",track.getTrackName(), track.getConfigName()));
    }

    @Test
    void testCarCategories() {
        NavigableSet<String> categories = new TreeSet<>();
        Arrays.stream(dataCache.getCars()).forEach(car -> categories.addAll(Arrays.stream(car.getCategories()).collect(Collectors.toList())));
        assertFalse(categories.isEmpty());
        categories.stream().sorted().forEach(log::info);
    }
}
