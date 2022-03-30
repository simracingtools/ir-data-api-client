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

    public static Map<Long, List<TrackInfoDto>> trackConfigurationMap(TrackInfoDto[] trackInfoDtos) {
        Map<Long, List<TrackInfoDto>> trackConfigMap = new TreeMap<>();

        Arrays.stream(trackInfoDtos).forEach(dto -> {
            List<TrackInfoDto> trackList = trackConfigMap.get(dto.getSku());
            if(trackList == null) {
                trackList = new ArrayList<>();
                trackConfigMap.put(dto.getSku(), trackList);
            }
            trackList.add(dto);
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

    private StockDataTools() {
        super();
    }
}
