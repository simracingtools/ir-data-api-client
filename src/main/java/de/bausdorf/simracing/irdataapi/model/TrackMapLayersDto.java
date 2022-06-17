package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class TrackMapLayersDto {
    @JsonProperty("background")
    private String background;
    @JsonProperty("inactive")
    private String inactive;
    @JsonProperty("active")
    private String active;
    @JsonProperty("pitroad")
    private String pitRoad;
    @JsonProperty("start-finish")
    private String startFinish;
    @JsonProperty("turns")
    private String turns;
}
