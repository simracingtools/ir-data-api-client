package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.bausdorf.simracing.irdataapi.client.DataApiConstants;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
public class RaceTimeDesciptorDto {
    @JsonProperty("repeating")
    private Boolean repeating;
    @JsonProperty("super_session")
    private Boolean superSession;
    @JsonProperty("session_minutes")
    private Long session_minutes;
    @JsonProperty("start_date")
    @JsonFormat(pattern = DataApiConstants.LOCAL_DATE_FORMAT)
    private LocalDate startDate;
    @JsonProperty("day_offset")
    private Integer[] dayOffset;
    @JsonProperty("first_session_time")
    @JsonFormat(pattern = DataApiConstants.LOCAL_TIME_FORMAT)
    private LocalTime first_session_time;
    @JsonProperty("repeat_minutes")
    private Integer repeatMinutes;
    @JsonProperty("session_times")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone = "UTC")
    private ZonedDateTime[] sessionTimes;
}
