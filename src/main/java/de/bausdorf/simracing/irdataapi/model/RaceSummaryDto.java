package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class RaceSummaryDto {
    @JsonProperty("subsession_id")
    private Long subsessionId;
    @JsonProperty("average_lap")
    private Long averageLap;
    @JsonProperty("laps_complete")
    private Long lapsComplete;
    @JsonProperty("num_cautions")
    private long numCautions;
    @JsonProperty("num_caution_laps")
    private Long numCautionLaps;
    @JsonProperty("num_lead_changes")
    private Long numLeadChanges;
    @JsonProperty("field_strength")
    private Long fieldStrength;
    @JsonProperty("num_opt_laps")
    private Long numOptLaps;
    @JsonProperty("has_opt_path")
    private Boolean hasOptPath;
    @JsonProperty("special_event_type")
    private Long specialEventType;
    @JsonProperty("special_event_type_text")
    private String specialEventTypeText;
}
