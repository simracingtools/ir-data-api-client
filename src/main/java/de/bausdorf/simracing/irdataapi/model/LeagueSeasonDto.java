package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class LeagueSeasonDto {
    @JsonProperty("league_id")
    private Long leagueId;
    @JsonProperty("season_id")
    private Long seasonId;
    @JsonProperty("points_system_id")
    private Long pointsystemId;
    @JsonProperty("season_name")
    private String seasonName;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("hidden")
    private Boolean hidden;
    @JsonProperty("num_drops")
    private Long numDrops;
    @JsonProperty("no_drops_on_or_after_race_num")
    private Long noDropsOnOrAfterRaceNum;
    @JsonProperty("points_cars")
    private CarPointDto[] pointsCars;
    @JsonProperty("driver_points_car_classes")
    private DriverPointsCarClassDto[] driverPointsCarClasses;
    @JsonProperty("team_points_car_classes")
    private DriverPointsCarClassDto[] teamPointsInCarClass;
    @JsonProperty("points_system_name")
    private String pointSystemName;
    @JsonProperty("points_system_desc")
    private String pointSystemDesc;
}
