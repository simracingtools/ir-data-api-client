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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarInfoDto {
    private String ai_enabled;
    private Boolean allow_number_colors;
    private Boolean allow_number_font;
    private Boolean allow_sponsor1;
    private Boolean allow_sponsor2;
    private Boolean allow_wheel_color;
    private Boolean award_exempt;
    private String car_dirpath;
    private Long car_id;
    private String car_name;
    private String car_name_abbreviated;
    private CarTypeDto[] car_types;
    private Long car_weight;
    private String[] categories;
    private String created;
    private Boolean free_with_subscription;
    private Boolean has_headlights;
    private Boolean has_multiple_dry_tire_types;
    private Long hp;
    private Long max_power_adjust_pct;
    private Long max_weight_penalty_kg;
    private Long min_power_adjust_pct;
    private Long package_id;
    private Long patterns;
    private Double price;
    private Boolean retired;
    private String search_filters;
    private Long sku;
}
