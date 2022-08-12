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

@Data
@NoArgsConstructor
public class LapChartEntryDto {
    @JsonProperty("group_id")
    private Long groupId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("cust_id")
    private Long custId;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("lap_number")
    private String lapNumber;
    @JsonProperty("flags")
    private Long flags;
    @JsonProperty("incident")
    private Boolean incident;
    @JsonProperty("session_time")
    private Long sessionTime;
    @JsonProperty("session_start_time")
    private Long sessionStartTime;
    @JsonProperty("lap_time")
    private Long lapTime;
    @JsonProperty("team_fastest_lap")
    private Boolean teamFastestLap;
    @JsonProperty("personal_best_lap")
    private Boolean personalBestLap;
    @JsonProperty("helmet")
    private HelmetDto helmet;
    @JsonProperty("license_level")
    private Long licenseLevel;
    @JsonProperty("car_number")
    private String carNumber;
    @JsonProperty("lap_events")
    private String[] lapEvents;
    @JsonProperty("lap_position")
    private Long lapPosition;
    @JsonProperty("interval")
    private String interval;
    @JsonProperty("interval_units")
    private String intervalUnits;
    @JsonProperty("fastest_lap")
    private Boolean fastestLap;
    @JsonProperty("ai")
    private Boolean ai;
}
