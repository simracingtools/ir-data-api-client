package de.bausdorf.simracing.irdataapi.tools;

import de.bausdorf.simracing.irdataapi.model.ScheduleDto;
import de.bausdorf.simracing.irdataapi.model.SeasonDto;
import org.springframework.lang.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SeasonTools {

    private SeasonTools() {
        super();
    }

    public static List<SeasonDto> filterByTrackType(@NonNull SeasonDto[] seasonDtos, @NonNull TrackTypeEnum trackType) {
        return Arrays.stream(seasonDtos)
                .filter(dto -> Arrays.stream(dto.getTrackTypes())
                            .anyMatch(tt -> tt.getTrackType().equalsIgnoreCase(trackType.toString()))
                )
                .collect(Collectors.toList());
    }

    public static List<SeasonDto> findBySeriesNameContains(@NonNull SeasonDto[] seasonDtos, @NonNull String namePart) {
        return Arrays.stream(seasonDtos)
                .filter(dto -> {
                            for(ScheduleDto scheduleDto : dto.getSchedules()) {
                                if(scheduleDto.getSeriesName().toLowerCase().contains(namePart.toLowerCase())) {
                                    return true;
                                }
                            }
                        return false;
                    })
                .collect(Collectors.toList());
    }
}
