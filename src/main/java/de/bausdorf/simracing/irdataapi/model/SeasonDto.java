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

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
public class SeasonDto {
    private Boolean active;
    private String allowed_season_members;
    private Long[] car_class_ids;
    private CarTypeDto[] car_types;
    private Boolean caution_laps_do_not_count;
    private Boolean complete;
    private Boolean cross_license;
    private Long driver_change_rule;
    private Boolean driver_changes;
    private Long drops;
    private Boolean fixed_setup;
    private Long green_white_checkered_limit;
    private Boolean grid_by_class;
    private Boolean ignore_license_for_practice;
    private Long incident_limit;
    private Long incident_warn_mode;
    private Long incident_warn_param1;
    private Long incident_warn_param2;
    private Boolean is_heat_racing;
    private Long license_group;
    private LicenseGroupTypeDto[] license_group_types;
    private Boolean lucky_dog;
    private Long max_team_drivers;
    private Long max_weeks;
    private Long min_team_drivers;
    private Boolean multiclass;
    private Boolean must_use_diff_tire_types_in_race;
    private String next_race_session;
    private Long num_opt_laps;
    private Boolean official;
    private Long op_duration;
    private Long open_practice_session_type_id;
    private Boolean qualifier_must_start_race;
    private Long race_week;
    private Long race_week_to_make_divisions;
    private Long reg_open_minutes;
    private Long reg_user_count;
    private Boolean region_competition;
    private Boolean restrict_by_member;
    private Boolean restrict_to_car;
    private Boolean restrict_viewing;
    private String rookie_season;
    private String schedule_description;
    private ScheduleDto[] schedules;
    private Long season_id;
    private String season_name;
    private Long season_quarter;
    private String season_short_name;
    private Long season_year;
    private Boolean send_to_open_practice;
    private Long series_id;
    private String start_date;
    private Boolean start_on_qual_tire;
    private TrackTypeDto[] track_types;
    private Long unsport_conduct_rule_mode;
    private HeatSessionInfoDto heat_ses_info;
}
