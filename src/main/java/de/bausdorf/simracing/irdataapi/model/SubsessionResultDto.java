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
public class SubsessionResultDto {
    @JsonProperty("subsession_id")
    private Long subsessionId;
    @JsonProperty("season_id")
    private Long seasonId;
    @JsonProperty("season_name")
    private String seasonName;
    @JsonProperty("season_short_name")
    private String SeasonShortName;
    @JsonProperty("season_year")
    private Long seasonYear;
    @JsonProperty("season_quarter")
    private Long seasonQuarter;
    @JsonProperty("series_id")
    private Long seriesId;
    @JsonProperty("series_name")
    private String seriesName;
    @JsonProperty("series_short_name")
    private String seriesShortName;
    @JsonProperty("series_logo")
    private String seriesLogo;
    @JsonProperty("race_week_num")
    private Long wareWeekNum;
    @JsonProperty("session_id")
    private Long sessionId;
    @JsonProperty("license_category_id")
    private Long licenseCategoryId;
    @JsonProperty("license_category")
    private String licenseCaegory;
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
    @JsonProperty("start_time")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone = "UTC")
    private ZonedDateTime startTime;
    @JsonProperty("end_time")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone = "UTC")
    private ZonedDateTime endTime;
    @JsonProperty("num_laps_for_qual_average")
    private Long numLapsForQualAverage;
    @JsonProperty("num_laps_for_solo_average")
    private Long numLapsForSoloAverage;
    @JsonProperty("corners_per_lap")
    private Long cornersPerLap;
    @JsonProperty("caution_type")
    private Long cautionType;
    @JsonProperty("event_type")
    private Long eventType;
    @JsonProperty("event_type_name")
    private String eventTypeName;
    @JsonProperty("driver_changes")
    private Boolean driverChanges;
    @JsonProperty("min_team_drivers")
    private Long minTeamDrivers;
    @JsonProperty("max_team_drivers")
    private Long maxTeamDrivers;
    @JsonProperty("driver_change_rule")
    private Long driverChangeRule;
    @JsonProperty("driver_change_param1")
    private Long driverChangeParam1;
    @JsonProperty("driver_change_param2")
    private Long driverChangeParam2;
    @JsonProperty("max_weeks")
    private Long maxWeeks;
    @JsonProperty("points_type")
    private String pointsType;
    @JsonProperty("event_strength_of_field")
    private Long eventStrengthOfField;
    @JsonProperty("event_average_lap")
    private Long eventAverageLap;
    @JsonProperty("event_laps_complete")
    private Long eventLapsComplete;
    @JsonProperty("num_cautions")
    private Long numCautions;
    @JsonProperty("num_caution_laps")
    private Long numCautionsLap;
    @JsonProperty("num_lead_changes")
    private Long numLeadChanges;
    @JsonProperty("official_session")
    private Boolean officialSession;
    @JsonProperty("heat_info_id")
    private Long heatInfoId;
    @JsonProperty("special_event_type")
    private Long specialEventType;
    @JsonProperty("damage_model")
    private Long damageModel;
    @JsonProperty("can_protest")
    private Boolean canProtest;
    @JsonProperty("cooldown_minutes")
    private Long cooldownMinutes;
    @JsonProperty("limit_minutes")
    private Long limitMinutes;
    @JsonProperty("track")
    private TrackRefDto track;
    @JsonProperty("weather")
    private WeatherDto weather;
    @JsonProperty("track_state")
    private TrackStateDto trackState;
    @JsonProperty("session_results")
    private SessionResultDto[] sessionResults;
    @JsonProperty("race_summary")
    private RaceSummaryDto raceSummary;
    @JsonProperty("car_classes")
    private CarClassDto[] carClasses;
    @JsonProperty("allowed_licenses")
    private LicenseInfoDto[] allowedLicenses;
    @JsonProperty("results_restricted")
    private Boolean resultsRestricted;
    @JsonProperty("associated_subsession_ids")
    private Long[] associatedSubsessionIds;
}
