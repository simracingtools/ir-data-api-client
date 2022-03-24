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
public class ScheduleDto {
    private Long season_id;
    private Long race_week_num;
    private Long series_id;
    private String series_name;
    private String season_name;
    private String schedule_name;
    private String start_date;
    private Long simulated_time_multiplier;
    private Long race_lap_limit;
    private Long race_time_limit;
    private String start_type;
    private String restart_type;
    private Boolean qual_attached;
    private Boolean yellow_flags;
    private String special_event_type;
    private TrackRefDto track;
    private TrackStateDto track_state;
    private WeatherDto weather;
    private CarRestrictionDto[] car_restrictions;
}
