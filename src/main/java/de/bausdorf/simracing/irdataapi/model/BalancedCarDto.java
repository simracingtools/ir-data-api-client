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
public class BalancedCarDto {
    @JsonProperty("car_id")
    private Long carId;
    @JsonProperty("car_class_id")
    private Long carClassId;
    @JsonProperty("max_pct_fuel_fill")
    private Long maxPctFuelFill;
    @JsonProperty("weight_penalty_kg")
    private Long weightPenaltyKg;
    @JsonProperty("power_adjust_pct")
    private Long powerAdjustPct;
    @JsonProperty("max_dry_tire_sets")
    private Long maxDryTireSets;
    @JsonProperty("package_id")
    private Long packageId;
    @JsonProperty("race_setup_id")
    private Long raceSetupId;
    @JsonProperty("race_setup_filename")
    private String raceSetupFileName;
    @JsonProperty("qual_setup_id")
    private Long qualSetupId;
    @JsonProperty("qual_setup_filename")
    private String qualSetupFileName;
}
