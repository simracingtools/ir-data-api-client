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

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@ToString
public class RaceTimeDesciptorDto {
    @JsonProperty("repeating")
    private Boolean repeating;
    @JsonProperty("super_session")
    private Boolean superSession;
    @JsonProperty("session_minutes")
    private Long sessionMinutes;
    @JsonProperty("start_date")
    @JsonFormat(pattern = DataApiConstants.LOCAL_DATE_FORMAT)
    private LocalDate startDate;
    @JsonProperty("day_offset")
    private Integer[] dayOffset;
    @JsonProperty("first_session_time")
    @JsonFormat(pattern = DataApiConstants.LOCAL_TIME_FORMAT)
    private LocalTime firstSessionTime;
    @JsonProperty("repeat_minutes")
    private Integer repeatMinutes;
    @JsonProperty("session_times")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone = "UTC")
    private ZonedDateTime[] sessionTimes;
}
