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
public class LeagueSeasonDto {
    @JsonProperty("league_id")
    private Long leagueId;
    @JsonProperty("season_id")
    private Long seasonId;
    @JsonProperty("points_system_id")
    private Long pointsystemId;
    @JsonProperty("season_name")
    private String seasonName;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("hidden")
    private Boolean hidden;
    @JsonProperty("num_drops")
    private Long numDrops;
    @JsonProperty("no_drops_on_or_after_race_num")
    private Long noDropsOnOrAfterRaceNum;
    @JsonProperty("points_cars")
    private CarPointDto[] pointsCars;
    @JsonProperty("driver_points_car_classes")
    private DriverPointsCarClassDto[] driverPointsCarClasses;
    @JsonProperty("team_points_car_classes")
    private DriverPointsCarClassDto[] teamPointsInCarClass;
    @JsonProperty("points_system_name")
    private String pointSystemName;
    @JsonProperty("points_system_desc")
    private String pointSystemDesc;
}
