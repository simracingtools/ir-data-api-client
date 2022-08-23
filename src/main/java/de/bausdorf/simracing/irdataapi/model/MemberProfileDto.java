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
public class MemberProfileDto {
    @JsonProperty("recent_awards")
    MemberAwardDto[] recentAwards;
    @JsonProperty("activity")
    MemberActivityDto activity;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("profile")
    private MemberProfileFieldDto[] profile;
    @JsonProperty("member_info")
    private MemberInfoDto memberInfo;
    @JsonProperty("field_defs")
    private MemberProfileFieldSpecDto[] fieldDefs;
    @JsonProperty("license_history")
    private MemberLicenseDto[] licenseHistory;
    @JsonProperty("is_generic_image")
    private Boolean isGenericImage;
    @JsonProperty("follow_counts")
    private MemberFollowCountDto followCounts;
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("disabled")
    private Boolean disabled;
    @JsonProperty("recent_events")
    MemberRecentEventDto[] recentEvents;
    @JsonProperty("cust_id")
    private Long custId;
}
