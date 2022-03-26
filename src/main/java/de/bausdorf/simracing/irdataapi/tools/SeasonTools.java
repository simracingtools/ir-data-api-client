package de.bausdorf.simracing.irdataapi.tools;

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
}
