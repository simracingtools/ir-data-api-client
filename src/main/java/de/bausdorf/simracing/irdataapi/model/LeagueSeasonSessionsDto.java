package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LeagueSeasonSessionsDto {
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("season_id")
    private Long seasonId;
    @JsonProperty("league_id")
    private Long leagueId;
    @JsonProperty("results_only")
    private Boolean resultsOnly;
    @JsonProperty("sessions")
    private LeagueSessionInfoDto[] sessions;
}
