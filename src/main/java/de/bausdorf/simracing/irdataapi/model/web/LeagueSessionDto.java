package de.bausdorf.simracing.irdataapi.model.web;

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

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LeagueSessionDto {
    @JsonProperty("practicedur")
    private Long practiceDuration;
    @JsonProperty("league_season_id")
    private Long leagueSeasonId;
    @JsonProperty("privatesessionid")
    private Long privateSessionId;
    @JsonProperty("registered")
    private String registered;
    @JsonProperty("min_ai_skill")
    private String minAiSkill;
    @JsonProperty("qualifiermuststartrace")
    private Long qualifierMustStartRace;
    @JsonProperty("password")
    private String password;
    @JsonProperty("race_status")
    private String raceStatus;
    @JsonProperty("incident_warn_mode")
    private Long incidentWarnMode;
    @JsonProperty("qualifylength")
    private Long qualifyLength;
    @JsonProperty("cars")
    private SessionCarDto[] cars;
    @JsonProperty("simulatedstarttime")
    private String simulatedStartTime;//: "2022-11-01+17%3A00",
    @JsonProperty("hs_qualopendelaysecs")
    private String hsQualOpenDelaySecs;
    @JsonProperty("isowner")
    private Long isOwner;
    @JsonProperty("custid")
    private Long custId;
    @JsonProperty("launchat")
    private Long launchAt;//: 1668621600000,
    @JsonProperty("custishost")
    private Long custIsHost;
    @JsonProperty("rn")
    private Long rn;
    @JsonProperty("racedur")
    private Long raceDuration;
    @JsonProperty("admins")
    private Long[] admins;
    @JsonProperty("timeOfDay")
    private Long timeOfDay;
    @JsonProperty("hs_qualnumlaps")
    private String hsQualNumLaps;
    @JsonProperty("qualtype")
    private String qualType;
    @JsonProperty("telemforcetodisk")
    private String telemForceToDisk;
    @JsonProperty("rubberlevel_practice")
    private Long rubberlevelPractice;
    @JsonProperty("grip_compound_practice")
    private Long gripCompoundPractice;
    @JsonProperty("ai_avoid_players")
    private Long aiAvoidPlayers;
    @JsonProperty("maxdrivers")
    private Long maxDrivers;
    @JsonProperty("driver_change_rule")
    private Long driverChangeRule;
    @JsonProperty("isadmin")
    private Long isAdmin;
    @JsonProperty("lucky_dog")
    private Long luckyDog;
    @JsonProperty("earth_rotation_speedup")
    private Long earthRotationSpeedup;
    @JsonProperty("subsessionid")
    private Long subSessionId;
    @JsonProperty("leavemarbles")
    private Long leaveMarbles;
    @JsonProperty("rubberlevel_qualify")
    private Long rubberLevelQualify;
    @JsonProperty("config_name")
    private String configName;//: "Gesamtstrecke+24h",
    @JsonProperty("stage_laps")
    private String stageLaps;
    @JsonProperty("leaguename")
    private String leagueName;//: "Winter+24h+of+the+N%C3%BCrburgring",
    @JsonProperty("telemrestriction")
    private Long telemRestriction;
    @JsonProperty("doNotPaintCars")
    private Boolean doNotPaintCars;
    @JsonProperty("warmupdur")
    private Long warmupDuration;
    @JsonProperty("hasgrid")
    private Long hasGrid;
    @JsonProperty("racelength")
    private Long raceLength;
    @JsonProperty("multiclass")
    private Long multiclass;
    @JsonProperty("fixedSetup")
    private Long fixedSetup;
    @JsonProperty("minliclevel")
    private Long minLicLevel;
    @JsonProperty("max_ai_skill")
    private String maxAiSkill;
    @JsonProperty("incident_warn_param2")
    private Long incidentWarnParam2;
    @JsonProperty("incident_warn_param1")
    private Long incidentWarnParam1;
    @JsonProperty("ingrid")
    private Long inGrid;
    @JsonProperty("qualdur")
    private Long qualDuration;
    @JsonProperty("numserversfinished")
    private Long numServersFinished;
    @JsonProperty("numserversstarted")
    private Long numServersStarted;
    @JsonProperty("passwordprotected")
    private Long passwordProtected;
    @JsonProperty("min_team_drivers")
    private Long minTeamDrivers;
    @JsonProperty("driver_change_param1")
    private String driverChangeParam1;
    @JsonProperty("driver_change_param2")
    private String driverChangeParam2;
    @JsonProperty("league_season_name")
    private String leagueSeasonName;//: "Single+Race",
    @JsonProperty("sessionname")
    private String sessionName;//: "Winter+24h+of+the+N%26%23252%3Brburgring",
    @JsonProperty("sessiondesc")
    private String sessionDesc;//: "",
    @JsonProperty("gwclimit")
    private Long gwcLimit;
    @JsonProperty("shortparadelap")
    private Long shortParadeLap;
    @JsonProperty("maxir")
    private Long maxIr;
    @JsonProperty("restarts")
    private Long restarts;
    @JsonProperty("hasentry")
    private Boolean hasEntry;
    @JsonProperty("start_time")
    private Long startTime;
    @JsonProperty("numservers")
    private Long numServers;
    @JsonProperty("leagueid")
    private Long leagueId;
    @JsonProperty("allowed_entities")
    private LeagueEntity[] leagueEntities;
    @JsonProperty("numfasttows")
    private Long numFastTows;
    @JsonProperty("racelaps")
    private Long raceLaps;
    @JsonProperty("rootprivatesessionname")
    private String rootPrivateSessionName;
    @JsonProperty("rootprivatesessionid")
    private String rootPrivateSessionId;
    @JsonProperty("incident_limit")
    private Long incidentLimit;
    @JsonProperty("trackid")
    private Long trackId;
    @JsonProperty("carsleft")
    private String carsLeft;
    @JsonProperty("restrictresults")
    private Long restrictResults;
    @JsonProperty("minir")
    private Long minIr;
    @JsonProperty("forceracestarttousequaltire")
    private Long forceRaceStartToUseQualTire;
    @JsonProperty("rubberlevel_race")
    private Long rubberLevelRace;
    @JsonProperty("max_ai_drivers")
    private Long maxAiDrivers;
    @JsonProperty("qualifylaps")
    private Long qualifyLaps;
    @JsonProperty("rollingstarts")
    private Long rollingStarts;
    @JsonProperty("fullcoursecautions")
    private Long fullCourseCautions;
    @JsonProperty("unsport_conduct_rule_mode")
    private Long unsportConductRuleMode;
    @JsonProperty("grip_compound_qualify")
    private Long gripCompoundQualify;
    @JsonProperty("ai_roster_name")
    private String aiRosterName;
    @JsonProperty("pitsinuse")
    private String pitsinuse;
    @JsonProperty("track_name")
    private String trackName;//: "N%C3%BCrburgring+Combined",
    @JsonProperty("farmimagepath")
    private String farmImagePath;//: "%2Fmember_images%2Fflags%2Fde.png",
    @JsonProperty("maxliclevel")
    private Long maxLicLevel;
    @JsonProperty("league_points_system_id")
    private String leaguePointsSystemId;
    @JsonProperty("timelimit")
    private Long timeLimit;
    @JsonProperty("max_team_drivers")
    private Long maxTeamDrivers;
    @JsonProperty("damageModel")
    private Long damageModel;
    @JsonProperty("rubberlevel_warmup")
    private Long rubberLevelWarmup;
    @JsonProperty("mustusedifftiretypesinrace")
    private Long mustUseDiffTireTypeInRace;
    @JsonProperty("hardcoreLevel")
    private Long hardcoreLevel;
    @JsonProperty("openregexpires")
    private Long openRegExpires;
    @JsonProperty("grip_compound_warmup")
    private Long gripCompoundWarmup;
    @JsonProperty("grip_compound_race")
    private Long gripCompoundRace;
    @JsonProperty("restrictviewing")
    private Long rectrictViewing;
    @JsonProperty("altassetid")
    private String altAssetId;
    @JsonProperty("farmdisplayname")
    private String farmDisplayName;
    @JsonProperty("driver_changes")
    private Long driverChanges;

    @JsonProperty("weather_skies")
    private Long weatherSkies;
    @JsonProperty("weather_wind_speed_units")
    private Long weatherWindSpeedUnits;
    @JsonProperty("weather_wind_speed_value")
    private Long weatherWindSpeedValue;
    @JsonProperty("weather_rh")
    private Long weatherRH;
    @JsonProperty("weather_var_ongoing")
    private Long weatherVarOngoing;
    @JsonProperty("weather_type")
    private Long weatherType;
    @JsonProperty("weather_fog_density")
    private Long weatherFogDensity;
    @JsonProperty("weather_wind_dir")
    private Long weatherWindDir;
    @JsonProperty("weather_temp_value")
    private Long weatherTempValue;
    @JsonProperty("weather_temp_units")
    private Long weatherTempUnits;
    @JsonProperty("weather_var_initial")
    private Long weatherValInitial;

    @JsonProperty("heatgridtype")
    private String heatGridType;
    @JsonProperty("heataddeddrivers")
    private String heatAddedDrivers;
    @JsonProperty("heatfiltertype")
    private String heatFilterType;
    @JsonProperty("heatsessiontype")
    private String heatSessionType;
    @JsonProperty("heatracesvrndx")
    private Long heatRaceSvrNdx;
    @JsonProperty("heatgridsid")
    private String heatGridSid;
    @JsonProperty("heatfilteramount")
    private String heatFilterAmount;

    @JsonProperty("hs_consolscoreschamppoints")
    private String hsConsolScoreChampPoints;
    @JsonProperty("hs_consolfirstsessionlenmins")
    private String hsConsolFirstSessionLenMins;
    @JsonProperty("hs_maxentrants")
    private String hsMaxEntrants;
    @JsonProperty("hs_consolnumtoconsolation")
    private String hsConsolNumToConsolation;
    @JsonProperty("hs_mainsessionlenmins")
    private String hsMainSessionLenMins;
    @JsonProperty("hs_mainnumlaps")
    private String hsMainNumLaps;
    @JsonProperty("hs_qualscoreschamppoints")
    private String hsQualScoreChampPoints;
    @JsonProperty("hs_heatnumpostoinvert")
    private String hsHeatNumPosToInvert;
    @JsonProperty("hs_is_hidden")
    private String hsIsHidden;
    @JsonProperty("hs_heatnumlaps")
    private String hsHeatNumLaps;
    @JsonProperty("hs_consolnumpostoinvert")
    private String hsConsolNumPosToInvert;
    @JsonProperty("hs_heatinfoid")
    private String hsHeatInfoId;
    @JsonProperty("hs_prequalnumtomain")
    private String hsPreQualNumToMain;
    @JsonProperty("hs_heatnumfromeachtomain")
    private String hsHeatNumFromEachToMain;
    @JsonProperty("hs_practiceisopen")
    private String hsPracticeIsOpen;
    @JsonProperty("hs_heatcautiontype")
    private String hsHeatCautionType;
    @JsonProperty("hs_consolfirstsessionnumlaps")
    private String hsConsolFirstSessionNumLaps;
    @JsonProperty("hs_custid")
    private String hsCustId;
    @JsonProperty("hs_prequalpracticelenmins")
    private String hsPreQualPracticeLenMins;
    @JsonProperty("hs_heatmaxfieldsize")
    private String hsHeatMaxFieldSize;
    @JsonProperty("hs_mainnumpostoinvert")
    private String hsMainNumPosToInvert;
    @JsonProperty("hs_racestyle")
    private String hsRaceStyle;
    @JsonProperty("hs_imageurl")
    private String hsImageUrl;
    @JsonProperty("hs_heatinfoname")
    private String hsHeatInfoName;
    @JsonProperty("hs_created")
    private Long hsCreated;
    @JsonProperty("hs_consoldeltamaxfieldsize")
    private String hsConsolDeltaMaxFieldSize;
    @JsonProperty("hs_qualstyle")
    private String hsQualStyle;
    @JsonProperty("hs_consoldeltasessionnumlaps")
    private String hsConsolDeltaSessionNumLaps;
    @JsonProperty("hs_description")
    private String hsDescription;
    @JsonProperty("hs_consolnumtomain")
    private String hsConsolNumToMain;
    @JsonProperty("hs_consoldeltasessionlenmins")
    private String hsConsolDeltaSessionLenMins;
    @JsonProperty("hs_premainpracticelenmins")
    private String hsPreMainInPracticeLenMins;
    @JsonProperty("hs_consolrunalways")
    private String hsConsolRunAlways;
    @JsonProperty("hs_qualscoring")
    private String hsQualScoring;
    @JsonProperty("hs_qualsessionlenmins")
    private String hsQualSessionLenMins;
    @JsonProperty("hs_qualcautiontype")
    private String hsQualCautionType;
    @JsonProperty("hs_qualnumtomain")
    private String hsQualNumToMain;
    @JsonProperty("hs_heatsessionlenmins")
    private String hsHeatSessionLenMins;
    @JsonProperty("hs_heatscoreschamppoints")
    private String hsHeatScoreChampPoints;
    @JsonProperty("hs_mainmaxfieldsize")
    private String hsMainMaxFieldSize;
    @JsonProperty("hs_consolfirstmaxfieldsize")
    private String hsConsolFirstMaxFieldSize;
    @JsonProperty("weather2_allow_fog")
    private Long w2allowFog;
    @JsonProperty("start_zone")
    private Long startZone;
    @JsonProperty("weather2_static_track_water")
    private Long w2TrackWater;
    @JsonProperty("weather2_version")
    private Long w2Version;
    @JsonProperty("weather2_precip_option")
    private Long w2PrecipOption;
}
