package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class SeasonListEntryDto {
    @JsonProperty("season_id")
    private Long seasonId;
    @JsonProperty("series_id")
    private Long seriesId;
    @JsonProperty("season_name")
    private String seasonName;
    @JsonProperty("series_name")
    private String seriesName;
    @JsonProperty("official")
    private Boolean official;
    @JsonProperty("season_year")
    private Long seasonYear;
    @JsonProperty("season_quarter")
    private Long seasonQuarter;
    @JsonProperty("rookie_season")
    private String rookieSeason;
    @JsonProperty("license_group")
    private Long licenseGroup;
    @JsonProperty("fixed_setup")
    private Boolean fixedSetup;
    @JsonProperty("driver_changes")
    private Boolean driverChanges;
}
