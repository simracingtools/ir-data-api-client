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
public class DriverStandingDto {
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
    private DriverLicenseInfoDto license;
    @JsonProperty("helmet")
    private HelmetDto helmet;
    @JsonProperty("weeks_counted")
    private Long weeksCounted;
    @JsonProperty("starts")
    private Long starts;
    @JsonProperty("wins")
    private Long wins;
    @JsonProperty("top5")
    private Long top5;
    @JsonProperty("top25_percent")
    private Long top25Percent;
    @JsonProperty("poles")
    private Long poles;
    @JsonProperty("avg_start_position")
    private Long avgStartPosition;
    @JsonProperty("avg_finish_position")
    private Long avgFinishPosition;
    @JsonProperty("avg_field_size")
    private Long avgFieldSize;
    @JsonProperty("laps")
    private Long laps;
    @JsonProperty("laps_led")
    private Long lapsLed;
    @JsonProperty("incidents")
    private Long incidents;
    @JsonProperty("points")
    private Long points;
    @JsonProperty("week_dropped")
    private Boolean weekDropped;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("country")
    private String country;
}
