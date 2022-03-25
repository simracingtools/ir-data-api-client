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
public class RecentRaceDto {
    @JsonProperty("season_id")
    private Long seasonId;
    @JsonProperty("series_id")
    private Long seriesId;
    @JsonProperty("series_name")
    private String seriesName;
    @JsonProperty("car_id")
    private Long carId;
    @JsonProperty("car_class_id")
    private Long carClassId;
    @JsonProperty("livery")
    private LiveryDto livery;
    @JsonProperty("license_level")
    private Long licenseLevel;
    @JsonProperty("session_start_time")
    private String sessionStartTime;
    @JsonProperty("winner_group_id")
    private Long winnerGroupId;
    @JsonProperty("winner_name")
    private String winnerName;
    @JsonProperty("winner_helmet")
    private HelmetDto winnerHelmet;
    @JsonProperty("winner_license_level")
    private Long winnerLicenseLevel;
    @JsonProperty("start_position")
    private Long startPosition;
    @JsonProperty("finish_position")
    private Long finishPosition;
    @JsonProperty("qualifying_time")
    private Long qualifyingTime;
    @JsonProperty("laps")
    private Long laps;
    @JsonProperty("laps_led")
    private Long lapsLed;
    @JsonProperty("incidents")
    private Long incidents;
    @JsonProperty("club_points")
    private Long clubPoints;
    @JsonProperty("points")
    private Long points;
    @JsonProperty("strength_of_field")
    private Long strengthOfField;
    @JsonProperty("subsession_id")
    private Long subsessionId;
    @JsonProperty("old_sub_level")
    private Long oldSubLevel;
    @JsonProperty("new_sub_level")
    private Long newSubLevel;
    @JsonProperty("oldi_rating")
    private Long oldiRating;
    @JsonProperty("newi_rating")
    private Long newiRating;
    @JsonProperty("track")
    private TrackRefDto track;
}
