package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class LeagueSeasonsDto {
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("retired")
    private Boolean retired;
    @JsonProperty("league_id")
    private Long leagueId;
    @JsonProperty("subscribed")
    private Boolean subscribed;
    @JsonProperty("seasons")
    private LeagueSeasonDto[] seasons;
}
