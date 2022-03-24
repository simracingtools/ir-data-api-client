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
public class WeatherDto {
    private Long type;
    private Long temp_units;
    private Long temp_value;
    private Long rel_humidity;
    private Long fog;
    private Long wind_dir;
    private Long wind_units;
    private Long wind_value;
    private Long skies;
    private Long weather_var_initial;
    private Long weather_var_ongoing;
    private Long time_of_day;
    private String simulated_start_time;
    private Long[] simulated_time_offsets;
    private Long simulated_time_multiplier;
    private String simulated_start_utc_time;
}