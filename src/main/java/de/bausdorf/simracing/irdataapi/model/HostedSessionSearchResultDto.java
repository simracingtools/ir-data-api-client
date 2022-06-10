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
public class HostedSessionSearchResultDto {
    @JsonProperty("session_id")
    private Long sessioId;
    @JsonProperty("subsession_id")
    private Long subsessionId;
    @JsonProperty("start_time")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone = "UTC")
    private ZonedDateTime startTime;
    @JsonProperty("end_time")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone = "UTC")
    private ZonedDateTime endTime;
    @JsonProperty("license_category_id")
    private Long licenseCategoryId;
    @JsonProperty("num_drivers")
    private Long numDrivers;
    @JsonProperty("num_cautions")
    private Long numCautions;
    @JsonProperty("num_caution_laps")
    private Long numCautionLaps;
    @JsonProperty("num_lead_changes")
    private Long numLeadChanges;
    @JsonProperty("event_laps_complete")
    private Long eventLapsComplete;
    @JsonProperty("driver_changes")
    private Boolean driverChanges;
    @JsonProperty("winner_group_id")
    private Long winnerGroupId;
    @JsonProperty("winner_ai")
    private Boolean winnerAi;
    @JsonProperty("track")
    private TrackRefDto track;
    @JsonProperty("private_session_id")
    private Long privateSessionId;
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
    @JsonProperty("created")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone = "UTC")
    private ZonedDateTime created;
    @JsonProperty("practice_length")
    private Long practiceLength;
    @JsonProperty("qualify_length")
    private Long qualifyLength;
    @JsonProperty("qualify_laps")
    private Long qualifyLaps;
    @JsonProperty("race_length")
    private Long raceLength;
    @JsonProperty("race_laps")
    private Long raceLaps;
    @JsonProperty("heat_race")
    private Boolean heatRace;
    @JsonProperty("host")
    private MemberRefDto host;
    @JsonProperty("cars")
    private CarResultRefDto[] cars;
}
