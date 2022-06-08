package de.bausdorf.simracing.irdataapi.model;

/*-
 * #%L
 * de.bausdorf.simracing:ir-data-api-client
 * %%
 * Copyright (C) 2022 bausdorf engineering
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.bausdorf.simracing.irdataapi.client.DataApiConstants;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.LinkedHashMap;

@Data
@NoArgsConstructor
public class CustomSessionInfoDto {
    @JsonProperty("num_drivers")
    private Long numDrivers;
    @JsonProperty("num_spotters")
    private Long numSpotters;
    @JsonProperty("num_spectators")
    private Long numSpectators;
    @JsonProperty("num_broadcasters")
    private Long numBroadcasters;
    @JsonProperty("available_reserved_broadcaster_slots")
    private Long availableReservedBroadcasterSlots;
    @JsonProperty("num_spectator_slots")
    private Long numSpectatorSlots;
    @JsonProperty("available_spectator_slots")
    private Long availbaleSpectatorSlots;
    @JsonProperty("can_broadcast")
    private Boolean canBroadcast;
    @JsonProperty("can_watch")
    private Boolean canWatch;
    @JsonProperty("can_spot")
    private Boolean canSpot;
    @JsonProperty("elig")
    private EligibilityDto eligibility;
    @JsonProperty("driver_changes")
    private Boolean driverChanges;
    @JsonProperty("restrict_viewing")
    private Boolean restrictViewing;
    @JsonProperty("max_users")
    private Long maxUsers;
    @JsonProperty("private_session_id")
    private Long privateSessionId;
    @JsonProperty("session_id")
    private Long sessionId;
    @JsonProperty("subsession_id")
    private Long subsessionId;
    @JsonProperty("password_protected")
    private Boolean passwordProtected;
    @JsonProperty("session_name")
    private String sessionName;
    @JsonProperty("session_desc")
    private String sessionDescription;
    @JsonProperty("open_reg_expires")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone = "UTC")
    private ZonedDateTime openRegExpires;
    @JsonProperty("launch_at")
    @JsonFormat(pattern = DataApiConstants.UTC_DATETIME_FORMAT, timezone = "UTC")
    private ZonedDateTime launchAt;
    @JsonProperty("full_course_cautions")
    private Boolean fullCourseCautions;
    @JsonProperty("num_fast_tows")
    private Long numFastTows;
    @JsonProperty("rolling_starts")
    private Boolean rollingStarts;
    @JsonProperty("restarts")
    private Long restarts;
    @JsonProperty("multiclass_type")
    private Long multiclassType;
    @JsonProperty("pits_in_use")
    private Long pitsInUse;
    @JsonProperty("cars_left")
    private Long carsLeft;
    @JsonProperty("max_drivers")
    private Long maxDrivers;
    @JsonProperty("hardcore_level")
    private Long hardcoreLevel;
    @JsonProperty("practice_length")
    private Long practiceLength;
    @JsonProperty("lone_qualify")
    private Boolean loneQualify;
    @JsonProperty("qualify_laps")
    private Long qualifyLaps;
    @JsonProperty("qualify_length")
    private Long qualifyLength;
    @JsonProperty("warmup_length")
    private Long warmupLength;
    @JsonProperty("race_laps")
    private Long raceLaps;
    @JsonProperty("race_length")
    private Long raceLength;
    @JsonProperty("time_limit")
    private Long timeLimit;
    @JsonProperty("restrict_results")
    private Boolean restrictResults;
    @JsonProperty("incident_limit")
    private Long incidentLimit;
    @JsonProperty("incident_warn_mode")
    private Long incidentWarnMode;
    @JsonProperty("incident_warn_param1")
    private Long incidentWarnParam1;
    @JsonProperty("incident_warn_param2")
    private Long incidentWarnParam2;
    @JsonProperty("unsport_conduct_rule_mode")
    private Long unsportConductRuleMode;
    @JsonProperty("lucky_dog")
    private Boolean luckyDog;
    @JsonProperty("min_team_drivers")
    private Long minTeamDrivers;
    @JsonProperty("max_team_drivers")
    private Long maxTeamDrivers;
    @JsonProperty("qualifier_must_start_race")
    private Boolean qualifierMustStartRace;
    @JsonProperty("driver_change_rule")
    private Long driverChangeRule;
    @JsonProperty("fixed_setup")
    private Boolean fixedSetup;
    @JsonProperty("entry_count")
    private Long entryCount;
    @JsonProperty("league_id")
    private Long leagueId;
    @JsonProperty("league_name")
    private String leagueName;
    @JsonProperty("league_season_id")
    private Long leagueSessionId;
    @JsonProperty("league_season_name")
    private String leagueSeasonName;
    @JsonProperty("session_type")
    private Long sessionType;
    @JsonProperty("race_length_type")
    private Long raceLengthType;
    @JsonProperty("order_id")
    private Long orderId;
    @JsonProperty("min_license_level")
    private Long minLicenseLevel;
    @JsonProperty("max_license_level")
    private Long maxLicenseLevel;
    @JsonProperty("status")
    private Long status;
    @JsonProperty("pace_car_id")
    private Long paceCarId;
    @JsonProperty("pace_car_class_id")
    private Long paceCarClassId;
    @JsonProperty("num_opt_laps")
    private Long numOptLaps;
    @JsonProperty("damage_model")
    private Long damageModel;
    @JsonProperty("do_not_paint_cars")
    private Boolean doNotPaintCars;
    @JsonProperty("green_white_checkered_limit")
    private Long greenWhiteCheckeredLimit;
    @JsonProperty("do_not_count_caution_laps")
    private Boolean doNotCountCautionLaps;
    @JsonProperty("consec_cautions_single_file")
    private Boolean consecCautionsSingleFile;
    @JsonProperty("no_lapper_wave_arounds")
    private Boolean noLapperWaveArounds;
    @JsonProperty("short_parade_lap")
    private Boolean shortParadeLap;
    @JsonProperty("start_on_qual_tire")
    private Boolean startOnQualTire;
    @JsonProperty("telemetry_restriction")
    private Long telemetryRestriction;
    @JsonProperty("telemetry_force_to_disk")
    private Long telemetryForceToDisk;
    @JsonProperty("max_ai_drivers")
    private Long maxAiDrivers;
    @JsonProperty("alt_asset_id")
    private Long altAssetId;
    @JsonProperty("ai_avoid_players")
    private Boolean aiAvoidPlayers;
    @JsonProperty("must_use_diff_tire_types_in_race")
    private Boolean mustUseDiffTireTypesInRace;
    @JsonProperty("start_zone")
    private Boolean startZone;
    @JsonProperty("session_full")
    private Boolean sessionFull;
    @JsonProperty("host")
    private MemberInfoDto host;
    @JsonProperty("track")
    private TrackRefDto track;
    @JsonProperty("weather")
    private WeatherDto weather;
    @JsonProperty("track_state")
    private TrackStateDto trackState;
    @JsonProperty("farm")
    private FarmDto farm;
    @JsonProperty("admins")
    private MemberInfoDto[] admins;
    @JsonProperty("allowed_clubs")
    private Long[] allowedClubs;
    @JsonProperty("allowed_teams")
    private Long[] allowedTeams;
    @JsonProperty("allowed_leagues")
    private Long[] allowedLeagues;
    @JsonProperty("cars")
    private BalancedCarDto[] cars;
    @JsonProperty("registered_teams")
    private Long[] registeredTeams;
    @JsonProperty("heat_ses_info")
    private HeatSessionInfoDto heatSessionInfo;
    @JsonProperty("count_by_car_id")
    private LinkedHashMap<String, Long> countByCarId;
    @JsonProperty("count_by_car_class_id")
    private LinkedHashMap<String, Long> countByCarClassId;
    @JsonProperty("car_types")
    private CarTypeDto[] carTypes;
    @JsonProperty("track_types")
    private TrackTypeDto[] trackTypes;
    @JsonProperty("license_group_types")
    private LicenseGroupTypeDto[] licenseGroupTypes;
    @JsonProperty("event_types")
    private EventTypeDto[] eventTypes;
    @JsonProperty("session_types")
    private SessionTypeDto[] sessionTypes;
    @JsonProperty("can_join")
    private Boolean canJoin;
    @JsonProperty("image")
    private ImageDto image;
    @JsonProperty("owner")
    private Boolean owner;
    @JsonProperty("admin")
    private Boolean admin;
    @JsonProperty("is_heat_racing")
    private Boolean isHeatRacing;
    @JsonProperty("team_entry_count")
    private Long teamEntryCount;
    @JsonProperty("populated")
    private Boolean populated;
    @JsonProperty("broadcaster")
    private Boolean broadcaster;
    @JsonProperty("min_ir")
    private Long minIr;
    @JsonProperty("max_ir")
    private Long maxIr;
}
