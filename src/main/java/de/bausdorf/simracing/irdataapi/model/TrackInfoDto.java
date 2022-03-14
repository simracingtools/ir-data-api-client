package de.bausdorf.simracing.irdataapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class TrackInfoDto {
    private Boolean ai_enabled;
    private Boolean award_exempt;
    private String banking;
    private String category;
    private Long category_id;
    private String closes;
    private String config_name;
    private Long corners_per_lap;
    private String created;
    private Boolean free_with_subscription;
    private Boolean fully_lit;
    private Long grid_stalls;
    private Boolean has_opt_path;
    private Boolean has_short_parade_lap;
    private Boolean has_svg_map;
    private Boolean is_dirt;
    private Boolean is_oval;
    private Long lap_scoring;
    private Double latitude;
    private String location;
    private Double longitude;
    private Long max_cars;
    private Boolean night_lighting;
    private Double nominal_lap_time;
    private Long number_pitstalls;
    private String opens;
    private Long package_id;
    private Long pit_road_speed_limit;
    private Double price;
    private Long priority;
    private Boolean purchasable;
    private Long qualify_laps;
    private Boolean restart_on_left;
    private Boolean retired;
    private String search_filters;
    private String site_url;
    private Long sku;
    private Long solo_laps;
    private Boolean start_on_left;
    private Boolean supports_grip_compound;
    private Boolean tech_track;
    private String time_zone;
    private Double track_config_length;
    private String track_dirpath;
    private Long track_id;
    private String track_name;
    private TrackTypeDto[] track_types;
}
