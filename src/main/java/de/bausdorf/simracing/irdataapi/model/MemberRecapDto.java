package de.bausdorf.simracing.irdataapi.model;

/*-
 * #%L
 * de.bausdorf.simracing:ir-data-api-client
 * %%
 * Copyright (C) 2022 - 2023 bausdorf engineering
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
public class MemberRecapDto {
    @JsonProperty("starts")
    private Long starts;
    @JsonProperty("wins")
    private Long wins;
    @JsonProperty("top5")
    private Long top5;
    @JsonProperty("avg_start_position")
    private Long avgStartPosition;
    @JsonProperty("avg_finish_position")
    private Long avgFinishPosition;
    @JsonProperty("laps")
    private Long laps;
    @JsonProperty("laps_led")
    private Long lapsLed;
    @JsonProperty("favorite_car")
    private CarRefLongDto favoriteCar;
    @JsonProperty("favorite_track")
    private TrackRefDto favoriteTrack;
}
