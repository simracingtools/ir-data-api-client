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
public class EventLogEntryDto {
    @JsonProperty("subsession_id")
    private Long subsessionId;
    @JsonProperty("simsession_number")
    private Long simsessionNumber;
    @JsonProperty("session_time")
    private Long sessionTime;
    @JsonProperty("event_seq")
    private Long eventSeq;
    @JsonProperty("event_code")
    private Long eventCode;
    @JsonProperty("group_id")
    private Long groupId;
    @JsonProperty("cust_id")
    private Long custId;
    @JsonProperty("lap_number")
    private Long lapNumber;
    @JsonProperty("description")
    private String description;
    @JsonProperty("message")
    private String message;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("team_name")
    private String teamName;
}
