package de.bausdorf.simracing.irdataapi.tools;

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

import de.bausdorf.simracing.irdataapi.model.CarClassDto;
import de.bausdorf.simracing.irdataapi.model.CarClassKey;
import de.bausdorf.simracing.irdataapi.model.CarInfoDto;
import de.bausdorf.simracing.irdataapi.model.TrackInfoDto;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class StockDataTools {

    public static final String LEGACY = "[Legacy]";

    public static Map<String, List<TrackInfoDto>> trackConfigurationMap(TrackInfoDto[] trackInfoDtos) {
        Map<String, List<TrackInfoDto>> trackConfigMap = new TreeMap<>();
        Arrays.stream(trackInfoDtos)
                .filter(track -> Arrays.stream(track.getTrackTypes()).anyMatch(type -> "road".equalsIgnoreCase(type.getTrackType())))
                .sorted(Comparator.comparing(TrackInfoDto::getTrackName))
                .forEach(trackConfig -> {
                    trackConfigMap.computeIfAbsent(trackConfig.getTrackName(),
                            k -> trackConfigMap.put(k, new ArrayList<>()));

                    trackConfigMap.get(trackConfig.getTrackName()).add(trackConfig);
                });
        return trackConfigMap;
    }

    public static Map<CarClassKey, List<CarInfoDto>> carClassMap(CarClassDto[] carClasses, CarInfoDto[] cars) {
        Map<CarClassKey, List<CarInfoDto>> carClassMap = new HashMap<>();
        Arrays.stream(carClasses).forEach(carClass -> {
            CarClassKey classKey = new CarClassKey(carClass);
            List<CarInfoDto> carsInClass = new ArrayList<>();
            Arrays.stream(carClass.getCarsInClass()).forEach(carInClass -> carsInClass.addAll(Arrays.stream(cars)
                    .filter(car -> car.getCarId().equals(carInClass.getCarId()))
                    .collect(Collectors.toList())));
            carClassMap.put(classKey, carsInClass);
        });
        return carClassMap;
    }

    public static List<CarInfoDto> carsInClasses(List<Long> carClassIds, CarClassDto[] carClasses, CarInfoDto[] cars) {
        List<CarInfoDto> carsInClasses = new ArrayList<>();
        Arrays.stream(carClasses)
                .filter(carClass -> carClassIds.contains(carClass.getCarClassId()))
                .forEach(carClass -> Arrays.stream(cars)
                        .filter(car -> Arrays.stream(carClass.getCarsInClass())
                                        .anyMatch(carInClass -> carInClass.getCarId().equals(car.getCarId()))
                        )
                        .forEach(carsInClasses::add));
        return carsInClasses;
    }

    public static NavigableSet<String> fetchAvailableCarTypes(CarInfoDto[] cars, MainCarType mainType) {
        NavigableSet<String> carTypes = new TreeSet<>();
        Arrays.stream(cars)
                .filter(car -> Arrays.stream(car.getCarTypes()).anyMatch(type -> type.getCarType().equalsIgnoreCase(mainType.toString())))
                .forEach(car -> Arrays.stream(car.getCarTypes()).forEach(type -> carTypes.add(type.getCarType())));
        return carTypes;
    }

    public static List<CarInfoDto> carsByType(CarInfoDto[] cars, String carType, boolean includeLegacy) {
        return Arrays.stream(cars)
                .filter(car -> Arrays.stream(car.getCarTypes()).anyMatch(type -> type.getCarType().equalsIgnoreCase(carType)))
                .filter(car -> (includeLegacy || !car.getCarName().contains(LEGACY)))
                .collect(Collectors.toList());
    }

    public static List<CarInfoDto> carsByCategory(CarInfoDto[] cars, CarCategoryType carType, boolean includeLegacy) {
        return Arrays.stream(cars)
                .filter(car -> Arrays.stream(car.getCarTypes()).anyMatch(type -> type.getCarType().equalsIgnoreCase(carType.toString())))
                .filter(car -> (includeLegacy || !car.getCarName().contains(LEGACY)))
                .collect(Collectors.toList());
    }

    public static List<CarInfoDto> carsByType(CarInfoDto[] cars, List<String> carTypes, boolean includeLegacy) {
        return Arrays.stream(cars)
                .filter(car -> Arrays.stream(car.getCarTypes()).anyMatch(type -> carTypes.contains(type.getCarType())))
                .filter(car -> (includeLegacy || !car.getCarName().contains(LEGACY)))
                .collect(Collectors.toList());
    }

    public static List<TrackInfoDto> tracksByType(TrackInfoDto[] tracks, TrackType trackType, boolean includeLegacy) {
        return Arrays.stream(tracks)
                .filter(track -> Arrays.stream(track.getTrackTypes()).anyMatch(type -> type.getTrackType().equalsIgnoreCase(trackType.toString())))
                .filter(track -> (includeLegacy || !track.getTrackName().contains(LEGACY)))
                .collect(Collectors.toList());
    }

    private StockDataTools() {
        super();
    }
}
