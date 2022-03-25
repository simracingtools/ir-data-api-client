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
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@ToString
public class WeatherDto {
    @JsonProperty("type")
    private Long type;
    @JsonProperty("temp_units")
    private Long tempUnits;
    @JsonProperty("temp_value")
    private Long tempValue;
    @JsonProperty("rel_humidity")
    private Long relHumidity;
    @JsonProperty("fog")
    private Long fog;
    @JsonProperty("wind_dir")
    private Long windDir;
    @JsonProperty("wind_units")
    private Long windUnits;
    @JsonProperty("wind_value")
    private Long windValue;
    @JsonProperty("skies")
    private Long skies;
    @JsonProperty("weather_var_initial")
    private Long weatherVarInitial;
    @JsonProperty("weather_var_ongoing")
    private Long weatherVarOngoing;
    @JsonProperty("time_of_day")
    private Long timeOfDay;
    @JsonProperty("simulated_start_time")
    @JsonFormat(pattern = DataApiConstants.LOCAL_DATETIME_FORMAT)
    private LocalDateTime simulatedStartTime;
    @JsonProperty("simulated_time_offsets")
    private Long[] simulatedTimeOffsets;
    @JsonProperty("simulated_time_multiplier")
    private Long simulatedTimeMultiplier;
    @JsonProperty("simulated_start_utc_time")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone = "UTC")
    private ZonedDateTime simulatedStartUtcTime;
}
