package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class MemberRecapDto {
    @JsonProperty("starts")
    private Long starts;
    @JsonProperty("wins")
    private Long wins;
    @JsonProperty("top5")
    private Long top5;
    @JsonProperty("avg_start_position")
    private Long avgStartPosition;
    @JsonProperty("avg_finish_position")
    private Long avgFinishPosition;
    @JsonProperty("laps")
    private Long laps;
    @JsonProperty("laps_led")
    private Long lapsLed;
    @JsonProperty("favorite_car")
    private CarRefLongDto favoriteCar;
    @JsonProperty("favorite_track")
    private TrackRefDto favoriteTrack;
}
