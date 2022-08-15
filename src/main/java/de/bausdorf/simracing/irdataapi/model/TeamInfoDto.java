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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.bausdorf.simracing.irdataapi.client.DataApiConstants;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@ToString
public class TeamInfoDto {
    @JsonProperty("team_id")
    private Long teamId;
    @JsonProperty("owner_id")
    private Long ownerId;
    @JsonProperty("team_name")
    private String teamName;
    @JsonProperty("created")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone = "UTC")
    private ZonedDateTime created;
    @JsonProperty("hidden")
    private Boolean hidden;
    @JsonProperty("message")
    private String message;
    @JsonProperty("about")
    private String about;
    @JsonProperty("url")
    private String url;
    @JsonProperty("roster_count")
    private Long rosterCount;
    @JsonProperty("recruiting")
    private Boolean recruting;
    @JsonProperty("private_wall")
    private Boolean privateWall;
    @JsonProperty("is_default")
    private Boolean isDefault;
    @JsonProperty("is_owner")
    private Boolean isOwner;
    @JsonProperty("is_admin")
    private Boolean isAdmin;
    @JsonProperty("suit")
    private SuitDto suit;
    @JsonProperty("owner")
    private TeamMemberDto owner;
    @JsonProperty("tags")
    private TagsDto tags;
    @JsonProperty("team_applications")
    private Object[] teamApplications;
    @JsonProperty("pending_requests")
    private Object[] pendingRequests;
    @JsonProperty("is_member")
    private Boolean isMember;
    @JsonProperty("is_applicant")
    private Boolean isApplicant;
    @JsonProperty("is_invite")
    private Boolean isInvite;
    @JsonProperty("is_ignored")
    private Boolean isIgnored;
    @JsonProperty("roster")
    private TeamMemberDto[] roster;
}
