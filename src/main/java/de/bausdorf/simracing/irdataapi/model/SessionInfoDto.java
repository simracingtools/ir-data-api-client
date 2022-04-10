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
import lombok.ToString;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@ToString
public class SessionInfoDto {
    @JsonProperty("subsession_id")
    private Long subsessionId;
    @JsonProperty("session_id")
    private Long sessionId;
    @JsonProperty("simsession_number")
    private Long simsessionNumber;
    @JsonProperty("simsession_type")
    private Long simsessionType;
    @JsonProperty("simsession_name")
    private String simsessionName;
    @JsonProperty("num_laps_for_qual_average")
    private Long numLapsForQualAverage;
    @JsonProperty("num_laps_for_solo_average")
    private Long numLapsForSoloAverage;
    @JsonProperty("event_type")
    private Long eventType;
    @JsonProperty("event_type_name")
    private String eventTypeName;
    @JsonProperty("private_session_id")
    private Long privateSessionId;
    @JsonProperty("host_id")
    private Long hostId;
    @JsonProperty("session_name")
    private String sessionName;
    @JsonProperty("league_id")
    private Long leagueId;
    @JsonProperty("league_name")
    private String leagueName;
    @JsonProperty("league_season_id")
    private Long leagueSeasonId;
    @JsonProperty("league_season_name")
    private String leagueSeasonName;
    @JsonProperty("restrict_results")
    private Boolean restrictResults;
    @JsonProperty("season_name")
    private String seasonName;
    @JsonProperty("season_short_name")
    private String seasonShortName;
    @JsonProperty("series_name")
    private String seriesName;
    @JsonProperty("series_short_name")
    private String seriesShortName;
    @JsonProperty("start_time")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone = "UTC")
    private ZonedDateTime startTime;
    @JsonProperty("track")
    private TrackRefDto track;
}
