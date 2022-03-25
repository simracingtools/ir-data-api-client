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

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class TrackInfoDto {
    @JsonProperty("ai_enabled")
    private Boolean aiEnabled;
    @JsonProperty("award_exempt")
    private Boolean awardExempt;
    @JsonProperty("banking")
    private String banking;
    @JsonProperty("category")
    private String category;
    @JsonProperty("category_id")
    private Long categoryId;
    @JsonProperty("closes")
    private String closes;
    @JsonProperty("config_name")
    private String configName;
    @JsonProperty("corners_per_lap")
    private Long cornersPerLap;
    @JsonProperty("created")
    private String created;
    @JsonProperty("free_with_subscription")
    private Boolean freeWithSubscription;
    @JsonProperty("fully_lit")
    private Boolean fullyLit;
    @JsonProperty("grid_stalls")
    private Long gridStalls;
    @JsonProperty("has_opt_path")
    private Boolean hasOptPath;
    @JsonProperty("has_short_parade_lap")
    private Boolean hasShortParadeLap;
    @JsonProperty("has_svg_map")
    private Boolean hasSvgMap;
    @JsonProperty("is_dirt")
    private Boolean isDirt;
    @JsonProperty("is_oval")
    private Boolean isOval;
    @JsonProperty("lap_scoring")
    private Long lapScoring;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("location")
    private String location;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("max_cars")
    private Long maxCars;
    @JsonProperty("night_lighting")
    private Boolean nightLighting;
    @JsonProperty("nominal_lap_time")
    private Double nominalLapTime;
    @JsonProperty("number_pitstalls")
    private Long numberPitstalls;
    @JsonProperty("opens")
    private String opens;
    @JsonProperty("package_id")
    private Long packageId;
    @JsonProperty("pit_road_speed_limit")
    private Long pitRoadSpeedLimit;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("priority")
    private Long priority;
    @JsonProperty("purchasable")
    private Boolean purchasable;
    @JsonProperty("qualify_laps")
    private Long qualifyLaps;
    @JsonProperty("restart_on_left")
    private Boolean restartOnLeft;
    @JsonProperty("retired")
    private Boolean retired;
    @JsonProperty("search_filters")
    private String searchFilters;
    @JsonProperty("site_url")
    private String siteUrl;
    @JsonProperty("sku")
    private Long sku;
    @JsonProperty("solo_laps")
    private Long soloLaps;
    @JsonProperty("start_on_left")
    private Boolean startOnLeft;
    @JsonProperty("supports_grip_compound")
    private Boolean supportsGripCompound;
    @JsonProperty("tech_track")
    private Boolean techTrack;
    @JsonProperty("time_zone")
    private String timezone;
    @JsonProperty("track_config_length")
    private Double trackConfigLength;
    @JsonProperty("track_dirpath")
    private String trackDirpath;
    @JsonProperty("track_id")
    private Long trackId;
    @JsonProperty("track_name")
    private String trackName;
    @JsonProperty("track_types")
    private TrackTypeDto[] trackTypes;
}
