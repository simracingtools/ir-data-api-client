package de.bausdorf.simracing.irdataapi.client;

/*-
 * #%L
 * iRDataAPIClient
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

import java.util.List;

public class DataApiConstants {

    // Infrastructure urls
    public static final String AUTH_URL = "https://members-ng.iracing.com/auth";
    public static final String GET_DOCS_URL = "https://members-ng.iracing.com/data/doc";

    // Endpoint urls

    public static final String GET_MEMBERS_URL =                "https://members-ng.iracing.com/data/member/get";
    public static final String GET_USERINFO_URL =               "https://members-ng.iracing.com/data/member/info";
    public static final String GET_MEMBER_SUMMARY_URL =         "https://members-ng.iracing.com/data/stats/member_summary";
    public static final String GET_MEMBER_YEARLY_URL =          "https://members-ng.iracing.com/data/stats/member_yearly";
    public static final String GET_MEMBER_RECENT_RACES_URL =    "https://members-ng.iracing.com/data/stats/member_recent_races";
    public static final String GET_MEMBER_CAREER_URL =          "https://members-ng.iracing.com/data/stats/member_career";
    public static final String GET_MEMBER_DIVISION_URL =        "https://members-ng.iracing.com/data/stats/member_division";
    public static final String GET_DRIVER_STANDINGS_URL =       "https://members-ng.iracing.com/data/stats/season_driver_standings";
    public static final String GET_TEAM_STANDINGS_URL =         "https://members-ng.iracing.com/data/stats/season_team_standings";
    public static final String GET_SUPERSESSION_STANDINGS_URL = "https://members-ng.iracing.com/data/stats/season_supersession_standings";
    public static final String GET_TT_STANDINGS_URL =           "https://members-ng.iracing.com/data/stats/season_tt_standings";
    public static final String GET_TT_RESULTS_URL =             "https://members-ng.iracing.com/data/stats/season_tt_results";
    public static final String GET_QUALIFY_RESULTS_URL =        "https://members-ng.iracing.com/data/stats/season_qualify_results";
    public static final String GET_CARS_URL =                   "https://members-ng.iracing.com/data/car/get";
    public static final String GET_CAR_ASSETS_URL =             "https://members-ng.iracing.com/data/car/assets";
    public static final String GET_CAR_CLASSES_URL =            "https://members-ng.iracing.com/data/carclass/get";
    public static final String GET_LEAGUE_URL =                 "https://members-ng.iracing.com/data/league/get";
    public static final String GET_TRACKS_URL =                 "https://members-ng.iracing.com/data/track/get";
    public static final String GET_TRACK_ASSETS_URL =           "https://members-ng.iracing.com/data/track/assets";
    public static final String GET_DIVISIONS_URL =              "https://members-ng.iracing.com/data/constants/divisions";
    public static final String GET_CATEGORIES_URL =              "https://members-ng.iracing.com/data/constants/categories";
    public static final String GET_EVENT_TYPES_URL =              "https://members-ng.iracing.com/data/constants/event_types";
    public static final String GET_LICENSES_URL =               "https://members-ng.iracing.com/data/lookup/licenses";
    public static final String GET_LOOKUP_URL =                 "https://members-ng.iracing.com/data/lookup/get";
    public static final String GET_SEASONS_URL =                "https://members-ng.iracing.com/data/series/seasons";
    public static final String GET_SERIES_STATS_URL =           "https://members-ng.iracing.com/data/series/stats_series";
    public static final String GET_SUBSESSION_RESULT_URL =      "https://members-ng.iracing.com/data/results/get";
    public static final String GET_LAP_CHART_DATA_URL =         "https://members-ng.iracing.com/data/results/lap_chart_data";
    public static final String GET_LAP_DATA_URL =               "https://members-ng.iracing.com/data/results/lap_data";
    public static final String GET_SEASON_RESULTS_URL =         "https://members-ng.iracing.com/data/results/season_results";
    public static final String GET_EVENT_LOG_URL =              "https://members-ng.iracing.com/data/results/event_log";
    public static final String GET_TEAM_MEMBERS_URL =           "https://members-ng.iracing.com/data/team/get";
    public static final String GET_LEAGUE_SESSIONS_URL =        "https://members-ng.iracing.com/data/league/cust_league_sessions";
    public static final String SEARCH_LEAGUE_DIRECTORY_URL =    "https://members-ng.iracing.com/data/league/directory";
    public static final String GET_LEAGUE_POINT_SYSTEMS_URL =   "https://members-ng.iracing.com/data/league/get_points_systems";

    public static final List<String> SUPPORTED_ENDPOINTS = List.of(
            GET_MEMBERS_URL, GET_USERINFO_URL,
            GET_MEMBER_SUMMARY_URL, GET_MEMBER_YEARLY_URL, GET_MEMBER_CAREER_URL, GET_MEMBER_RECENT_RACES_URL, GET_MEMBER_DIVISION_URL,
            GET_DRIVER_STANDINGS_URL, GET_TEAM_STANDINGS_URL, GET_TT_STANDINGS_URL, GET_TT_RESULTS_URL, GET_QUALIFY_RESULTS_URL, GET_SUPERSESSION_STANDINGS_URL,
            GET_CARS_URL, GET_CAR_ASSETS_URL, GET_CAR_CLASSES_URL,
            GET_LEAGUE_URL,
            GET_TRACKS_URL, GET_TRACK_ASSETS_URL,
            GET_DIVISIONS_URL, GET_EVENT_TYPES_URL, GET_CATEGORIES_URL,
            GET_LOOKUP_URL, GET_LICENSES_URL,
            GET_SEASONS_URL, GET_SERIES_STATS_URL,
            GET_SUBSESSION_RESULT_URL, GET_LAP_CHART_DATA_URL, GET_LAP_DATA_URL, GET_SEASON_RESULTS_URL, GET_EVENT_LOG_URL,
            GET_TEAM_MEMBERS_URL, GET_LEAGUE_SESSIONS_URL, SEARCH_LEAGUE_DIRECTORY_URL, GET_LEAGUE_POINT_SYSTEMS_URL
    );

    // Date and time format constants for json deserialization
    public static final String UTC_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final String UTC_PRECISE_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.n'Z'";
    public static final String LOCAL_DATE_FORMAT = "yyyy-MM-dd";
    public static final String LOCAL_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    // constants for event_type
    public static final Long EVENT_TYPE_PRACTICE = 2L;
    public static final Long EVENT_TYPE_QUALIFY = 3L;
    public static final Long EVENT_TYPE_TT = 4L;
    public static final Long EVENT_TYPE_RACE = 5L;

    private DataApiConstants() {
        super();
    }
}
