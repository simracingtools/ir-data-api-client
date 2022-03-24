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
@ToString
public class HeatSessionInfoDto {
    private Long heat_info_id;
    private Long cust_id;
    private Boolean hidden;
    private String created;
    private String heat_info_name;
    private String description;
    private Long max_entrants;
    private Long race_style;
    private Boolean open_practice;
    private Long pre_qual_practice_length_minutes;
    private Long pre_qual_num_to_main;
    private Long qual_style;
    private Long qual_length_minutes;
    private Long qual_laps;
    private Long qual_num_to_main;
    private Long qual_scoring;
    private Long qual_caution_type;
    private Long qual_open_delay_seconds;
    private Boolean qual_scores_champ_points;
    private Long heat_length_minutes;
    private Long heat_laps;
    private Long heat_max_field_size;
    private Long heat_num_position_to_invert;
    private Long heat_caution_type;
    private Long heat_num_from_each_to_main;
    private Boolean heat_scores_champ_points;
    private Long consolation_num_to_consolation;
    private Long consolation_num_to_main;
    private Long consolation_first_max_field_size;
    private Long consolation_first_session_length_minutes;
    private Long consolation_first_session_laps;
    private Long consolation_delta_max_field_size;
    private Long consolation_delta_session_length_minutes;
    private Long consolation_delta_session_laps;
    private Long consolation_num_position_to_invert;
    private Boolean consolation_scores_champ_points;
    private Boolean consolation_run_always;
    private Long pre_main_practice_length_minutes;
    private Long main_length_minutes;
    private Long main_laps;
    private Long main_max_field_size;
    private Long main_num_position_to_invert;
    private Long heat_session_minutes_estimate;
}
