package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class ClubHistoryDto {
    @JsonProperty("club_id")
    private Long clubId;
    @JsonProperty("club_name")
    private String clubName;
    @JsonProperty("season_year")
    private Long seasonYear;
    @JsonProperty("season_quarter")
    private Long seasonQuarter;
    @JsonProperty("region")
    private String region;

}
