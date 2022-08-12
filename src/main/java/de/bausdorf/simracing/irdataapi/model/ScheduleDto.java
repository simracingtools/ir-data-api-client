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
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@ToString
public class ScheduleDto {
    @JsonProperty("season_id")
    private Long seasonId;
    @JsonProperty("race_week_num")
    private Long raceWeekNum;
    @JsonProperty("series_id")
    private Long seriesId;
    @JsonProperty("series_name")
    private String seriesName;
    @JsonProperty("season_name")
    private String seasonName;
    @JsonProperty("schedule_name")
    private String scheduleName;
    @JsonProperty("start_date")
    @JsonFormat(pattern = DataApiConstants.LOCAL_DATE_FORMAT)
    private LocalDate startDate;
    @JsonProperty("simulated_time_multiplier")
    private Long simulatedTimeMultiplier;
    @JsonProperty("race_lap_limit")
    private Long raceLapLimit;
    @JsonProperty("race_time_limit")
    private Long raceTimeLimit;
    @JsonProperty("start_type")
    private String startType;
    @JsonProperty("restart_type")
    private String restartType;
    @JsonProperty("qual_attached")
    private Boolean qualAttached;
    @JsonProperty("yellow_flags")
    private Boolean yellowFlags;
    @JsonProperty("special_event_type")
    private String specialEventType;
    @JsonProperty("track")
    private TrackRefDto track;
    @JsonProperty("track_state")
    private TrackStateDto trackState;
    @JsonProperty("weather")
    private WeatherDto weather;
    @JsonProperty("car_restrictions")
    private CarRestrictionDto[] carRestrictions;
    @JsonProperty("start_zone")
    private Boolean startZone;
    @JsonProperty("full_course_cautions")
    private Boolean fullCourseCautions;
    @JsonProperty("race_time_descriptors")
    private RaceTimeDesciptorDto[] raceTimeDescriptors;
}
