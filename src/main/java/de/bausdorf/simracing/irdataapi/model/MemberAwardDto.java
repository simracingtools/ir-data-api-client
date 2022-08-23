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

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MemberAwardDto {
    @JsonProperty("member_award_id")
    private Long memberAwardId;
    @JsonProperty("cust_id")
    private Long custId;
    @JsonProperty("award_id")
    private Long awardId;
    @JsonProperty("subsession_id")
    private Long subsessionId;
    @JsonProperty("award_date")
    @JsonFormat(pattern = DataApiConstants.LOCAL_DATE_FORMAT)
    private LocalDate awardDate;
    @JsonProperty("description")
    private String description;
    @JsonProperty("awarded_description")
    private String awardedDescription;
    @JsonProperty("viewed")
    private Boolean viewed;
    @JsonProperty("name")
    private String name;
    @JsonProperty("group_name")
    private String groupName;
    @JsonProperty("icon_url_small")
    private String iconUrlSmall;
    @JsonProperty("icon_url_large")
    private String iconUrlLarge;
    @JsonProperty("icon_url_unawarded")
    private String iconUrlUnawarded;
    @JsonProperty("weight")
    private Long weight;
    @JsonProperty("award_count")
    private Long awardCount;
    @JsonProperty("award_order")
    private Long awardOrder;
    @JsonProperty("achievement")
    private Boolean achievement;
    @JsonProperty("threshold")
    private Long threshold;
    @JsonProperty("progress")
    private Long progress;
    @JsonProperty("progress_label")
    private String progressLabel;
}
