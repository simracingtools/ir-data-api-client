package de.bausdorf.simracing.irdataapi.model.web;

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
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class TeamMemberDto extends WebDto {
    @JsonProperty("teamName")
    private String teamName;
    @JsonProperty("lastLoginText")
    private String lastLoginText;
    @JsonProperty("lastLoginTime")
    private Long lastLoginTime;
    @JsonProperty("isDefault")
    private Boolean defaultMember;
    @JsonProperty("isOwner")
    private Boolean owner;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("helmet")
    private HelmetDto helmet;
    @JsonProperty("teamID")
    private Long teamId;
    @JsonProperty("custID")
    private Long custId;
    @JsonProperty("online")
    private Boolean online;
    @JsonProperty("isAdmin")
    private Boolean isAdmin;

    public String getTeamName() {
        return decode(teamName);
    }

    public String getDisplayName() {
        return decode(displayName);
    }

    public String getLastLoginText() {
        return decode(lastLoginText);
    }
}
