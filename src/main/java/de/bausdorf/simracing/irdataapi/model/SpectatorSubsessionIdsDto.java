package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SpectatorSubsessionIdsDto {
    @JsonProperty("event_types")
    private Long[] eventTypes;
    @JsonProperty("subsession_ids")
    private Long[] subsessionIds;
    @JsonProperty("success")
    private Boolean success;
}
