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
public class DriverQualifyStandingDto {
    @JsonProperty("rank")
    private Long rank;
    @JsonProperty("cust_id")
    private Long custId;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("division")
    private Long division;
    @JsonProperty("club_id")
    private Long clubId;
    @JsonProperty("club_name")
    private String clubName;
    @JsonProperty("license")
    DriverLicenseInfoDto license;
    @JsonProperty("best_qual_lap_time")
    private Long bestQualLapTime;
}
