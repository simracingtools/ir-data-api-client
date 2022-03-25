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
public class SeasonDto {
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("allowed_season_members")
    private String allowedSeasonMembers;
    @JsonProperty("car_class_ids")
    private Long[] carClassIds;
    @JsonProperty("car_types")
    private CarTypeDto[] carTypes;
    @JsonProperty("caution_laps_do_not_count")
    private Boolean cautionLapsDoNotCount;
    @JsonProperty("complete")
    private Boolean complete;
    @JsonProperty("cross_license")
    private Boolean crossLicense;
    @JsonProperty("driver_change_rule")
    private Long driverChangeRule;
    @JsonProperty("driver_changes")
    private Boolean driverChanges;
    @JsonProperty("drops")
    private Long drops;
    @JsonProperty("fixed_setup")
    private Boolean fixedSetup;
    @JsonProperty("green_white_checkered_limit")
    private Long greenWhiteCheckeredLimit;
    @JsonProperty("grid_by_class")
    private Boolean gridByClass;
    @JsonProperty("ignore_license_for_practice")
    private Boolean ignoreLicenseForPractice;
    @JsonProperty("incident_limit")
    private Long incidentLimit;
    @JsonProperty("incident_warn_mode")
    private Long incidentWarnMode;
    @JsonProperty("incident_warn_param1")
    private Long incidentWarnParam1;
    @JsonProperty("incident_warn_param2")
    private Long incidentWarnParam2;
    @JsonProperty("is_heat_racing")
    private Boolean isHeatRacing;
    @JsonProperty("license_group")
    private Long licenseGroup;
    @JsonProperty("license_group_types")
    private LicenseGroupTypeDto[] licenseGroupTypes;
    @JsonProperty("lucky_dog")
    private Boolean luckyDog;
    @JsonProperty("max_team_drivers")
    private Long maxTeamDrivers;
    @JsonProperty("max_weeks")
    private Long maxWeeks;
    @JsonProperty("min_team_drivers")
    private Long minTeamDrivers;
    @JsonProperty("multiclass")
    private Boolean multiclass;
    @JsonProperty("must_use_diff_tire_types_in_race")
    private Boolean mustUseDiffTireTypesInRace;
    @JsonProperty("next_race_session")
    private String nextRaceSession;
    @JsonProperty("num_opt_laps")
    private Long numOptLaps;
    @JsonProperty("official")
    private Boolean official;
    @JsonProperty("op_duration")
    private Long opDuration;
    @JsonProperty("open_practice_session_type_id")
    private Long openPracticeSessionTypeId;
    @JsonProperty("qualifier_must_start_race")
    private Boolean qualifierMustStartRace;
    @JsonProperty("race_week")
    private Long raceWeek;
    @JsonProperty("race_week_to_make_divisions")
    private Long raceWeekToMakeDivisions;
    @JsonProperty("reg_open_minutes")
    private Long regOpenMinutes;
    @JsonProperty("reg_user_count")
    private Long regUserCount;
    @JsonProperty("region_competition")
    private Boolean regionCompetition;
    @JsonProperty("restrict_by_member")
    private Boolean restrictByMember;
    @JsonProperty("restrict_to_car")
    private Boolean restrictToCar;
    @JsonProperty("restrict_viewing")
    private Boolean restrictViewing;
    @JsonProperty("rookie_season")
    private String rookieSeason;
    @JsonProperty("schedule_description")
    private String scheduleDescription;
    @JsonProperty("schedules")
    private ScheduleDto[] schedules;
    @JsonProperty("season_id")
    private Long seasonId;
    @JsonProperty("season_name")
    private String seasonName;
    @JsonProperty("season_quarter")
    private Long seasonQuarter;
    @JsonProperty("season_short_name")
    private String seasonShortName;
    @JsonProperty("season_year")
    private Long seasonYear;
    @JsonProperty("send_to_open_practice")
    private Boolean sendToOpenPractice;
    @JsonProperty("series_id")
    private Long seriesId;
    @JsonProperty("start_date")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone="GMT")
    private ZonedDateTime startDate;
    @JsonProperty("start_on_qual_tire")
    private Boolean startOnQualTire;
    @JsonProperty("track_types")
    private TrackTypeDto[] trackTypes;
    @JsonProperty("unsport_conduct_rule_mode")
    private Long unsportConductRuleMode;
    @JsonProperty("heat_ses_info")
    private HeatSessionInfoDto heatSesInfo;
}
