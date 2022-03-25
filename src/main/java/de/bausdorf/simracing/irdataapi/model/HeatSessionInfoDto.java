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

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class HeatSessionInfoDto {
    @JsonProperty("heat_info_id")
    private Long heatInfoId;
    @JsonProperty("cust_id")
    private Long custId;
    @JsonProperty("hidden")
    private Boolean hidden;
    @JsonProperty("created")
    private String created;
    @JsonProperty("heat_info_name")
    private String heatInfoName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("max_entrants")
    private Long maxEntrants;
    @JsonProperty("race_style")
    private Long raceStyle;
    @JsonProperty("open_practice")
    private Boolean openPractice;
    @JsonProperty("pre_qual_practice_length_minutes")
    private Long preQualPracticeLengthMinutes;
    @JsonProperty("pre_qual_num_to_main")
    private Long preQualNumToMain;
    @JsonProperty("qual_style")
    private Long qualStyle;
    @JsonProperty("qual_length_minutes")
    private Long qualLengthMinutes;
    @JsonProperty("qual_laps")
    private Long qualLaps;
    @JsonProperty("qual_num_to_main")
    private Long qualNumToMain;
    @JsonProperty("qual_scoring")
    private Long qualScoring;
    @JsonProperty("qual_caution_type")
    private Long qualCautionType;
    @JsonProperty("qual_open_delay_seconds")
    private Long qualOpenDelaySeconds;
    @JsonProperty("qual_scores_champ_points")
    private Boolean qualScoresChampPoints;
    @JsonProperty("heat_length_minutes")
    private Long heatLengthMinutes;
    @JsonProperty("heat_laps")
    private Long heatLaps;
    @JsonProperty("heat_max_field_size")
    private Long heatMaxFieldSize;
    @JsonProperty("heat_num_position_to_invert")
    private Long heatNumPositionToInvert;
    @JsonProperty("heat_caution_type")
    private Long heatCautionType;
    @JsonProperty("heat_num_from_each_to_main")
    private Long heatNumFromEachToMain;
    @JsonProperty("heat_scores_champ_points")
    private Boolean heatScoresChampPoints;
    @JsonProperty("consolation_num_to_consolation")
    private Long consolationNumToConsolation;
    @JsonProperty("consolation_num_to_main")
    private Long consolationNumToMain;
    @JsonProperty("consolation_first_max_field_size")
    private Long consolationFirstMaxFieldSize;
    @JsonProperty("consolation_first_session_length_minutes")
    private Long consolationFirstSessionLengthMinutes;
    @JsonProperty("consolation_first_session_laps")
    private Long consolationFirstSessionLaps;
    @JsonProperty("consolation_delta_max_field_size")
    private Long consolationDeltaMaxFieldSize;
    @JsonProperty("consolation_delta_session_length_minutes")
    private Long consolationDeltaSessionLengthMinutes;
    @JsonProperty("consolation_delta_session_laps")
    private Long consolationDeltaSessionLaps;
    @JsonProperty("consolation_num_position_to_invert")
    private Long consolationNumPositionToInvert;
    @JsonProperty("consolation_scores_champ_points")
    private Boolean consolationScoresChampPoints;
    @JsonProperty("consolation_run_always")
    private Boolean consolationRunAlways;
    @JsonProperty("pre_main_practice_length_minutes")
    private Long preMainPracticeLengthMinutes;
    @JsonProperty("main_length_minutes")
    private Long mainLengthMinutes;
    @JsonProperty("main_laps")
    private Long mainLaps;
    @JsonProperty("main_max_field_size")
    private Long mainMaxFieldSize;
    @JsonProperty("main_num_position_to_invert")
    private Long mainNumPositionToInvert;
    @JsonProperty("heat_session_minutes_estimate")
    private Long heatSessionMinutesEstimate;
}
