package de.bausdorf.simracing.irdataapi.model;

/*-
 * #%L
 * iRDataAPIClient
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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.bausdorf.simracing.irdataapi.client.DataApiConstants;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarInfoDto {
    @JsonProperty("ai_enabled")
    private String aiEnabled;
    @JsonProperty("allow_number_colors")
    private Boolean allowNumberColors;
    @JsonProperty("allow_number_font")
    private Boolean allowNumberFont;
    @JsonProperty("allow_sponsor1")
    private Boolean allowSponsor1;
    @JsonProperty("allow_sponsor2")
    private Boolean allowSponsor2;
    @JsonProperty("allow_wheel_color")
    private Boolean allowWheelColor;
    @JsonProperty("award_exempt")
    private Boolean awardExempt;
    @JsonProperty("car_dirpath")
    private String carDirpath;
    @JsonProperty("car_id")
    private Long carId;
    @JsonProperty("car_name")
    private String carName;
    @JsonProperty("car_name_abbreviated")
    private String carNameAbbreviated;
    @JsonProperty("car_types")
    private CarTypeDto[] carTypes;
    @JsonProperty("car_weight")
    private Long carWeight;
    @JsonProperty("categories")
    private String[] categories;
    @JsonProperty("created")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone = "UTC")
    private ZonedDateTime created;
    @JsonProperty("free_with_subscription")
    private Boolean freeWithSubscription;
    @JsonProperty("has_headlights")
    private Boolean hasHeadlights;
    @JsonProperty("has_multiple_dry_tire_types")
    private Boolean hasMultipleDryTireTypes;
    @JsonProperty("hp")
    private Long hp;
    @JsonProperty("max_power_adjust_pct")
    private Long maxPowerAdjustPct;
    @JsonProperty("max_weight_penalty_kg")
    private Long maxWeightPenaltyKg;
    @JsonProperty("min_power_adjust_pct")
    private Long minPowerAdjustPct;
    @JsonProperty("package_id")
    private Long packageId;
    @JsonProperty("patterns")
    private Long patterns;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("retired")
    private Boolean retired;
    @JsonProperty("search_filters")
    private String searchFilters;
    @JsonProperty("sku")
    private Long sku;
}
