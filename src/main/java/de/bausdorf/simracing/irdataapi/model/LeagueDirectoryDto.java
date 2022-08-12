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
public class LeagueDirectoryDto {
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("lowerbound")
    private Long lowerBound;
    @JsonProperty("upperbound")
    private Long upperBound;
    @JsonProperty("row_count")
    private Long rowCount;
    @JsonProperty("search")
    private String search;
    @JsonProperty("restrict_to_member")
    private Boolean restrictToMember;
    @JsonProperty("restrict_to_recruiting")
    private Boolean restrictToRecruiting;
    @JsonProperty("restrict_to_friends")
    private Boolean restrictToFriends;
    @JsonProperty("restrict_to_watched")
    private Boolean restrictToWatched;
    @JsonProperty("minimum_roster_count")
    private Long minimumRosterCount;
    @JsonProperty("maximum_roster_count")
    private Long maximumRosterCount;
    @JsonProperty("sort")
    private String sort;  // One of relevance, leaguename, displayname, rostercount. displayname is owners's name. Defaults to relevance.
    @JsonProperty("order")
    private String order; // One of asc or desc.  Defaults to asc.
    @JsonProperty("results_page")
    private LeagueDirectoryEntryDto[] leagueEntries;
}
