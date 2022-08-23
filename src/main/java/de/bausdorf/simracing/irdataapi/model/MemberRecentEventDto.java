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
public class MemberRecentEventDto {
    @JsonProperty("event_type")
    private String eventType;
    @JsonProperty("subsession_id")
    private Long subsessionId;
    @JsonProperty("start_time")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone = "UTC")
    private ZonedDateTime startTime;
    @JsonProperty("event_id")
    private Long eventId;
    @JsonProperty("event_name")
    private String eventName;
    @JsonProperty("simsession_type")
    private Long simsessionType;
    @JsonProperty("starting_position")
    private Long startingPosition;
    @JsonProperty("finish_position")
    private Long finishPosition;
    @JsonProperty("best_lap_time")
    private Long bestLapTime;
    @JsonProperty("percent_rank")
    private Long percentRank;
    @JsonProperty("car_id")
    private Long carId;
    @JsonProperty("car_name")
    private String carName;
    @JsonProperty("logo_url")
    private String logoUrl;
    @JsonProperty("track")
    private TrackRefDto track;
}
