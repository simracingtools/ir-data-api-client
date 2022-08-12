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
public class LeagueMemberDto {
    @JsonProperty("cust_id")
    private Long custId;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("helmet")
    private HelmetDto helmet;
    @JsonProperty("owner")
    private Boolean owner;
    @JsonProperty("admin")
    private Boolean admin;
    @JsonProperty("league_mail_opt_out")
    private Boolean leagueMailOptOut;
    @JsonProperty("league_pm_opt_out")
    private Boolean leaguePmOptOut;
    @JsonProperty("league_member_since")
    private String leagueMemberSince;
    @JsonProperty("car_number")
    private String carNumber;
    @JsonProperty("nick_name")
    private String nickName;
}
