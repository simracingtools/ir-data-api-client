package de.bausdorf.simracing.irdataapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.bausdorf.simracing.irdataapi.client.DataApiConstants;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
public class MemberSessionResultDto {
    @JsonProperty("cust_id")
    private Long custId;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("finish_position")
    private Long finishPosition;
    @JsonProperty("finish_position_in_class")
    private Long finishPositionInClass;
    @JsonProperty("laps_lead")
    private Long lapsLed;
    @JsonProperty("laps_complete")
    private Long lapsComplete;
    @JsonProperty("opt_laps_complete")
    private Long optLapsComplete;
    @JsonProperty("interval")
    private Long interval;
    @JsonProperty("class_interval")
    private Long classInterval;
    @JsonProperty("average_lap")
    private Long averageLap;
    @JsonProperty("best_lap_num")
    private Long bestLapNum;
    @JsonProperty("best_lap_time")
    private Long bestLapTime;
    @JsonProperty("best_nlaps_num")
    private Long bestNlapsNum;
    @JsonProperty("best_nlaps_time")
    private Long bestNlapsTime;
    @JsonProperty("best_qual_lap_at")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone = "UTC")
    private ZonedDateTime bestQualLapAt;
    @JsonProperty("best_qual_lap_num")
    private Long bestQualLapNum;
    @JsonProperty("best_qual_lap_time")
    private Long bestQualLapTime;
    @JsonProperty("reason_out_id")
    private Long reasonOutId;
    @JsonProperty("reason_out")
    private String reasonOut;
    @JsonProperty("champ_points")
    private Long champPoints;
    @JsonProperty("drop_race")
    private Boolean dropRace;
    @JsonProperty("club_points")
    private Long clubPoints;
    @JsonProperty("position")
    private Long position;
    @JsonProperty("qual_lap_time")
    private Long qualLapTime;
    @JsonProperty("starting_position")
    private Long startingPosition;
    @JsonProperty("car_class_id")
    private Long carClassId;
    @JsonProperty("club_id")
    private Long clubId;
    @JsonProperty("club_name")
    private String clubName;
    @JsonProperty("club_shortname")
    private String clubShortName;
    @JsonProperty("division")
    private Long division;
    @JsonProperty("division_name")
    private String divisionName;
    @JsonProperty("old_license_level")
    private Long oldLicenseLevel;
    @JsonProperty("old_sub_level")
    private Long oldSubLevel;
    @JsonProperty("old_cpi")
    private Long oldCpi;
    @JsonProperty("oldi_rating")
    private Long oldIRating;
    @JsonProperty("old_ttrating")
    private Long oldTTRating;
    @JsonProperty("new_license_level")
    private Long newLicenseLevel;
    @JsonProperty("new_sub_level")
    private Long newSubLevel;
    @JsonProperty("new_cpi")
    private Long newCpi;
    @JsonProperty("newi_rating")
    private Long newIRating;
    @JsonProperty("new_ttrating")
    private Long newTTRating;
    @JsonProperty("multiplier")
    private Long multiplier;
    @JsonProperty("license_change_oval")
    private Long licenseChangeOval;
    @JsonProperty("license_change_road")
    private Long licenseChangeRoad;
    @JsonProperty("incidents")
    private Long incidents;
    @JsonProperty("max_pct_fuel_fill")
    private Long maxPctFuelFill;
    @JsonProperty("weight_penalty_kg")
    private Long weightPenaltyKg;
    @JsonProperty("league_points")
    private Long leaguePoints;
    @JsonProperty("league_agg_points")
    private Long leagueAggPoints;
    @JsonProperty("car_id")
    private Long carId;
    @JsonProperty("aggregate_champ_points")
    private Long aggregateChampPoints;
    @JsonProperty("watched")
    private Boolean watched;
    @JsonProperty("friend")
    private Boolean friend;
    @JsonProperty("ai")
    private Boolean ai;
    @JsonProperty("livery")
    private LiveryDto livery;
    @JsonProperty("suit")
    private SuitDto suit;
    @JsonProperty("helmet")
    private HelmetDto helmet;
}
