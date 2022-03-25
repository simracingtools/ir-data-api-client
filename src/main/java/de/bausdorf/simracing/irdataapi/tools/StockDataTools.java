package de.bausdorf.simracing.irdataapi.tools;

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

    private StockDataTools() {
        super();
    }
}
