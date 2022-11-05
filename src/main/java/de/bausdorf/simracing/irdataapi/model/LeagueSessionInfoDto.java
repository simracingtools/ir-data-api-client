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
public class LeagueSessionInfoDto {
    @JsonProperty("driver_changes")
    private Boolean driverChanges;
    @JsonProperty("private_session_id")
    private Long privateSessionId;
    @JsonProperty("session_id")
    private Long sessionId;
    @JsonProperty("subsession_id")
    private Long subsessionId;
    @JsonProperty("session_name")
    private String sessionName;
    @JsonProperty("session_desc")
    private String sessionDescription;
    @JsonProperty("launch_at")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone = "UTC")
    private ZonedDateTime launchAt;
    @JsonProperty("full_course_cautions")
    private Boolean fullCourseCautions;
    @JsonProperty("practice_length")
    private Long practiceLength;
    @JsonProperty("lone_qualify")
    private Boolean loneQualify;
    @JsonProperty("qualify_laps")
    private Long qualifyLaps;
    @JsonProperty("qualify_length")
    private Long qualifyLength;
    @JsonProperty("warmup_length")
    private Long warmupLength;
    @JsonProperty("race_laps")
    private Long raceLaps;
    @JsonProperty("race_length")
    private Long raceLength;
    @JsonProperty("time_limit")
    private Long timeLimit;
    @JsonProperty("lucky_dog")
    private Boolean luckyDog;
    @JsonProperty("fixed_setup")
    private Boolean fixedSetup;
    @JsonProperty("entry_count")
    private Long entryCount;
    @JsonProperty("league_id")
    private Long leagueId;
    @JsonProperty("league_name")
    private String leagueName;
    @JsonProperty("league_season_id")
    private Long leagueSeasonId;
    @JsonProperty("league_season_name")
    private String leagueSeasonName;
    @JsonProperty("status")
    private Long status;
    @JsonProperty("damage_model")
    private Long damageModel;
    @JsonProperty("do_not_paint_cars")
    private Boolean doNotPaintCars;
    @JsonProperty("green_white_checkered_limit")
    private Long greenWhiteCheckeredLimit;
    @JsonProperty("do_not_count_caution_laps")
    private Boolean doNotCountCautionLaps;
    @JsonProperty("consec_cautions_single_file")
    private Boolean consecCautionsSingleFile;
    @JsonProperty("no_lapper_wave_arounds")
    private Boolean noLapperWaveArounds;
    @JsonProperty("num_opt_laps")
    private Long numOptLaps;
    @JsonProperty("pace_car_id")
    private Long paceCarId;
    @JsonProperty("pace_car_class_id")
    private Long paceCarClassId;
    @JsonProperty("password_protected")
    private Boolean passwordProtected;
    @JsonProperty("short_parade_lap")
    private Boolean shortParadeLap;
    @JsonProperty("start_on_qual_tire")
    private Boolean startOnQualTire;
    @JsonProperty("team_entry_count")
    private Long teamEntryCount;
    @JsonProperty("telemetry_restriction")
    private Long telemetryRestriction;
    @JsonProperty("telemetry_force_to_disk")
    private Long telemetryForceToDisk;
    @JsonProperty("max_ai_drivers")
    private Long maxAiDrivers;
    @JsonProperty("must_use_diff_tire_types_in_race")
    private Boolean mustUseDiffTireTypesInRace;
    @JsonProperty("start_zone")
    private Boolean startZone;
    @JsonProperty("track")
    private TrackRefDto track;
    @JsonProperty("weather")
    private WeatherDto weather;
    @JsonProperty("track_state")
    private TrackStateDto trackState;
    @JsonProperty("cars")
    private CarRefLongDto[] cars;
    private HeatSessionInfoDto heatSessionInfo;
    @JsonProperty("has_results")
    private Boolean hasResults;
    @JsonProperty("winner_id")
    private Long winnerId;
    @JsonProperty("winner_name")
    private String winnerName;
}
