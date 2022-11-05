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

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
public class UserInfoDto {
    @JsonProperty("cust_id")
    private Long custId;
    @JsonProperty("email")
    private String email;
    @JsonProperty("username")
    private String username;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("on_car_name")
    private String onCarName;
    @JsonProperty("member_since")
    private String memberSince;
    @JsonProperty("last_test_track")
    private Long lastTestTrack;
    @JsonProperty("last_test_car")
    private Long lastTestCar;
    @JsonProperty("last_season")
    private Long lastSeason;
    @JsonProperty("flags")
    private Long flags;
    @JsonProperty("club_id")
    private Long clubId;
    @JsonProperty("club_name")
    private String clubName;
    @JsonProperty("connection_type")
    private String connectionType;
    @JsonProperty("download_server")
    private String downloadServer;
    @JsonProperty("last_login")
    @JsonFormat(pattern = DataApiConstants.UTC_PRECISE_DATETIME_FORMAT, timezone = "UTC")
    private String lastLogin;
    @JsonProperty("read_comp_rules")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone = "UTC")
    private ZonedDateTime readCompRules;
    @JsonProperty("account")
    private AccountDto account;
    @JsonProperty("helmet")
    private HelmetDto helmet;
    @JsonProperty("suit")
    private SuitDto suit;
    @JsonProperty("licenses")
    private UserLicensesDto licenses;
    @JsonProperty("car_packages")
    private PackageDto[] carPackages;
    @JsonProperty("track_packages")
    private PackageDto[] trackPackages;
    @JsonProperty("other_owned_packages")
    private Long[] otherOwnedPackages;
    @JsonProperty("dev")
    private Boolean dev;
    @JsonProperty("alpha_tester")
    private Boolean alphaTester;
    @JsonProperty("broadcaster")
    private Boolean broadcaster;
    @JsonProperty("restrictions")
    private Object restrictions;
    @JsonProperty("has_read_comp_rules")
    private Boolean hasReadCompRules;
    @JsonProperty("flags_hex")
    private String flagsHex;
    @JsonProperty("hundred_pct_club")
    private Boolean hundredPctClub;
    @JsonProperty("twenty_pct_discount")
    private Boolean twentyPctDiscount;
    @JsonProperty("race_official")
    private Boolean raceOffical;
    @JsonProperty("ai")
    private Boolean ai;
    @JsonProperty("read_tc")
    private ZonedDateTime readTc;
    @JsonProperty("read_pp")
    private ZonedDateTime readPp;
    @JsonProperty("has_read_tc")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone = "UTC")
    private Boolean hasReadTc;
    @JsonProperty("has_read_pp")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone = "UTC")
    private Boolean hasReadPp;
    @JsonProperty("bypass_hosted_password")
    private Boolean bypassHostedPassword;
}
