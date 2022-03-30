package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SeasonResultsDto {
    @JsonProperty("results_list")
    private RaceResultSummaryDto[] resultsList;
    @JsonProperty("event_type")
    private Long eventType;
    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("season_id")
    private Boolean seasonId;
    @JsonProperty("race_week_num")
    private Long raceWeekNum;
}
