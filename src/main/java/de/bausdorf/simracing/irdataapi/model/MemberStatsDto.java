package de.bausdorf.simracing.irdataapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class MemberStatsDto {
    private Long category_id;
    private String category;
    private Long starts;
    private Long wins;
    private Long top5;
    private Long poles;
    private Long avg_start_position;
    private Long avg_finish_position;
    private Long laps;
    private Long laps_led;
    private Long avg_incidents;
    private Long avg_points;
    private Long win_percentage;
    private Long top5_percentage;
    private Long laps_led_percentage;
    private Long total_club_points;
    private Long year;
}
