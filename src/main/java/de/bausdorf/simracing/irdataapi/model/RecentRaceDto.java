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
public class RecentRaceDto {
    private Long season_id;
    private Long series_id;
    private String series_name;
    private Long car_id;
    private Long car_class_id;
    private LiveryDto livery;
    private Long license_level;
    private String session_start_time;
    private Long winner_group_id;
    private String winner_name;
    private HelmetDto winner_helmet;
    private Long winner_license_level;
    private Long start_position;
    private Long finish_position;
    private Long qualifying_time;
    private Long laps;
    private Long laps_led;
    private Long incidents;
    private Long club_points;
    private Long points;
    private Long strength_of_field;
    private Long subsession_id;
    private Long old_sub_level;
    private Long new_sub_level;
    private Long oldi_rating;
    private Long newi_rating;
    private TrackRefDto track;
}
