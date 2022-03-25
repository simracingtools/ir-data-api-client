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
public class LeagueInfoDto {
    @JsonProperty("league_id")
    private Long leagueId;
    @JsonProperty("owner_id")
    private Long ownerId;
    @JsonProperty("league_name")
    private String leagueName;
    @JsonProperty("created")
    private String created;
    @JsonProperty("hidden")
    private Boolean hidden;
    @JsonProperty("message")
    private String message;
    @JsonProperty("url")
    private String url;
    @JsonProperty("recruiting")
    private Boolean recruiting;
    @JsonProperty("private_wall")
    private Boolean privateWall;
    @JsonProperty("private_roster")
    private Boolean privateRoster;
    @JsonProperty("private_schedule")
    private Boolean privateSchedule;
    @JsonProperty("private_results")
    private Boolean privateResults;
    @JsonProperty("roster_count")
    private Long rosterCount;
    @JsonProperty("owner")
    private LeagueOwnerDto owner;
    @JsonProperty("image")
    private ImageDto image;
    @JsonProperty("tags")
    private TagsDto tags;
    @JsonProperty("roster")
    private LeagueMemberDto[] roster;
}
