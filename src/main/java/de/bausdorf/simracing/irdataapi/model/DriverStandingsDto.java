package de.bausdorf.simracing.irdataapi.model;

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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.bausdorf.simracing.irdataapi.client.DataApiConstants;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
public class DriverStandingsDto {
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("season_id")
    private Long seasonId;
    @JsonProperty("season_name")
    private String seasonName;
    @JsonProperty("season_short_name")
    private String seasonShortName;
    @JsonProperty("series_id")
    private Long seriesId;
    @JsonProperty("series_name")
    private String seriesName;
    @JsonProperty("car_class_id")
    private Long carClassId;
    @JsonProperty("race_week_num")
    private Long raceWeekNum;
    @JsonProperty("division")
    private Long division;
    @JsonProperty("club_id")
    private Long clubId;
    @JsonProperty("last_updated")
    @JsonFormat(pattern = DataApiConstants.UTC_PRECISE_DATETIME_FORMAT, timezone = "UTC")
    private ZonedDateTime lastUpdated;
    @JsonProperty("chunk_info")
    private ChunkInfoDto chunkInfo;
}
