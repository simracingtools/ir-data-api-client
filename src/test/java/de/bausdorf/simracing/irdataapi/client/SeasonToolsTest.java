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

import de.bausdorf.simracing.irdataapi.client.impl.IRacingObjectMapper;
import de.bausdorf.simracing.irdataapi.model.SeasonDto;
import de.bausdorf.simracing.irdataapi.tools.SeasonTools;
import de.bausdorf.simracing.irdataapi.tools.TrackTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

@Slf4j
class SeasonToolsTest {

    static SeasonDto[] seasonDtos;

    @BeforeAll
    static void loadSeasonDto() {
        try(InputStream is = ClassLoader.getSystemResourceAsStream("season-22-2.json")) {
            IRacingObjectMapper mapper = new IRacingObjectMapper();

            seasonDtos = mapper.readValue(is, SeasonDto[].class);
        } catch (IOException e) {
            fail(e.getMessage(), e);
        }
    }

    @Test
    void listRoadSeries() {
        List<SeasonDto> roadSeries = SeasonTools.filterByTrackType(seasonDtos, TrackTypeEnum.ROAD);
        Assertions.assertNotNull(roadSeries);
        Assertions.assertFalse(roadSeries.isEmpty());

        roadSeries.forEach(dto -> log.info("{}: {} starts {}", dto.getSeriesId(), dto.getSeasonName(), dto.getStartDate()));
    }

    @Test
    void findSeriesByName() {
        List<SeasonDto> enduranceSeries = SeasonTools.findBySeriesNameContains(seasonDtos, "endurance");
        Assertions.assertNotNull(enduranceSeries);
        Assertions.assertFalse(enduranceSeries.isEmpty());

        enduranceSeries.forEach(dto -> log.info("{}: {} - {}", dto.getSeriesId(), dto.getSeasonName(), dto.getSchedules()[0].getSeriesName()));
    }

    @Test
    @Disabled("Used to fetch existing distinct names to define enum")
    void listAllTrackTypes() {
        var trackTypeNames = new HashSet<String>();

        Arrays.stream(seasonDtos)
                .forEach(dto -> Arrays.stream(dto.getTrackTypes()).forEach(trackType -> trackTypeNames.add(trackType.getTrackType())));

        trackTypeNames.forEach(log::info);
    }

    @Test
    @Disabled("Used to fetch existing distinct names to define enum")
    void listAllCarTypes() {
        var carTypeNames = new HashSet<String>();

        Arrays.stream(seasonDtos)
                .forEach(dto -> Arrays.stream(dto.getCarTypes()).forEach(trackType -> carTypeNames.add(trackType.getCarType())));

        carTypeNames.forEach(log::info);
    }
}
