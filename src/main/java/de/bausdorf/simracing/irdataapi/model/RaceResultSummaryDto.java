package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.bausdorf.simracing.irdataapi.client.DataApiConstants;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@ToString
public class RaceResultSummaryDto {
    @JsonProperty("race_week_num")
    private Long raceWeekNum;
    @JsonProperty("event_type")
    private Long eventType;
    @JsonProperty("event_type_name")
    private String eventTypeName;
    @JsonProperty("start_time")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone = "UTC")
    private ZonedDateTime startTime;
    @JsonProperty("session_id")
    private Long sessionId;
    @JsonProperty("subsession_id")
    private Long subsessionId;
    @JsonProperty("official_session")
    private boolean officialSession;
    @JsonProperty("event_strength_of_field")
    private Long eventStrengthOfField;
    @JsonProperty("event_best_lap_time")
    private Long eventBestLapTime;
    @JsonProperty("num_cautions")
    private Long numCautions;
    @JsonProperty("num_caution_laps")
    private Long numCautionLaps;
    @JsonProperty("num_lead_changes")
    private Long numLeadChanges;
    @JsonProperty("num_drivers")
    private Long numDrivers;
    @JsonProperty("track")
    private TrackRefDto track;
}
