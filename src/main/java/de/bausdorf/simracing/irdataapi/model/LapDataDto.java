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
public class LapDataDto {
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("session_info")
    private SessionInfoDto sessionInfo;
    @JsonProperty("best_lap_num")
    private Long bestLapNum;
    @JsonProperty("best_lap_time")
    private Long bestLapTime;
    @JsonProperty("best_nlaps_num")
    private Long bestNlapsNum;
    @JsonProperty("best_nlaps_time")
    private Long bestNlapsTime;
    @JsonProperty("best_qual_lap_num")
    private Long bestQualLapNum;
    @JsonProperty("best_qual_lap_time")
    private Long bestQualLapTime;
    @JsonProperty("best_qual_lap_at")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone = "UTC")
    private ZonedDateTime bestQualLapAt;
    @JsonProperty("chunk_info")
    private ChunkInfoDto chunkInfo;
    @JsonProperty("group_id")
    private Long groupId;
    @JsonProperty("cust_id")
    private Long custId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("car_id")
    private Long carId;
    @JsonProperty("license_level")
    private Long licenseLevel;
    @JsonProperty("livery")
    private LiveryDto livery;
}
