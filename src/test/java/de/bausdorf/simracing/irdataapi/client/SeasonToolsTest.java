package de.bausdorf.simracing.irdataapi.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import de.bausdorf.simracing.irdataapi.client.impl.IRacingObjectMapper;
import de.bausdorf.simracing.irdataapi.model.SeasonDto;
import de.bausdorf.simracing.irdataapi.tools.SeasonTools;
import de.bausdorf.simracing.irdataapi.tools.TrackTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

@Slf4j
class SeasonToolsTest {

    static SeasonDto[] seasonDto;

    @BeforeAll
    static void loadSeasonDto() {
        try(InputStream is = ClassLoader.getSystemResourceAsStream("season-22-2.json")) {
            IRacingObjectMapper mapper = new IRacingObjectMapper();

            seasonDto = mapper.readValue(is, SeasonDto[].class);
        } catch (IOException e) {
            fail(e.getMessage(), e);
        }
    }

    @Test
    void listRoadSeries() {
        List<SeasonDto> roadSeries = SeasonTools.filterByTrackType(seasonDto, TrackTypeEnum.ROAD);
        Assertions.assertNotNull(roadSeries);
        Assertions.assertFalse(roadSeries.isEmpty());

        roadSeries.forEach(dto -> log.info("{}: {} starts {}", dto.getSeriesId(), dto.getSeasonName(), dto.getStartDate()));
    }

    @Test
    void listAllTrackTypes() {
        var trackTypeNames = new HashSet<String>();

        Arrays.stream(seasonDto)
                .forEach(dto -> Arrays.stream(dto.getTrackTypes()).forEach(trackType -> trackTypeNames.add(trackType.getTrackType())));

        trackTypeNames.forEach(log::info);
    }
}
