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

@Data
@NoArgsConstructor
public class LeagueInfoDto {
    private Long league_id;
    private Long owner_id;
    private String league_name;
    private String created;
    private Boolean hidden;
    private String message;
    private String url;
    private Boolean recruiting;
    private Boolean private_wall;
    private Boolean private_roster;
    private Boolean private_schedule;
    private Boolean private_results;
    private Long roster_count;//": 573,
    private LeagueOwnerDto owner;
    private ImageDto image;
    private TagsDto tags;
    private LeagueMemberDto[] roster;
}
