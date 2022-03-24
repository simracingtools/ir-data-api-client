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
public class MemberStatsDto {
    private Long category_id;
    private String category;
    private Long starts;
    private Long wins;
    private Long top5;
    private Long poles;
    private Long avg_start_position;
    private Long avg_finish_position;
    private Long laps;
    private Long laps_led;
    private Long avg_incidents;
    private Long avg_points;
    private Long win_percentage;
    private Long top5_percentage;
    private Long laps_led_percentage;
    private Long total_club_points;
    private Long year;
}
