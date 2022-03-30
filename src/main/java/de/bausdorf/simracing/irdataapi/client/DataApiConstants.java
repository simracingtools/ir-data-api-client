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

public class DataApiConstants {

    // Endpoint urls
    public static final String AUTH_URL = "https://members-ng.iracing.com/auth";
    public static final String GET_MEMBERS_URL = "https://members-ng.iracing.com/data/member/get";
    public static final String GET_MEMBER_SUMMARY_URL = "https://members-ng.iracing.com/data/stats/member_summary";
    public static final String GET_MEMBER_YEARLY_URL = "https://members-ng.iracing.com/data/stats/member_yearly";
    public static final String GET_MEMBER_RECENT_RACES_URL = "https://members-ng.iracing.com/data/stats/member_recent_races";
    public static final String GET_MEMBER_CAREER_URL = "https://members-ng.iracing.com/data/stats/member_career";
    public static final String GET_CARS_URL = "https://members-ng.iracing.com/data/car/get";
    public static final String GET_CAR_ASSETS_URL = "https://members-ng.iracing.com/data/car/assets";
    public static final String GET_CAR_CLASSES_URL = "https://members-ng.iracing.com/data/carclass/get";
    public static final String GET_LEAGUE_URL = "https://members-ng.iracing.com/data/league/get";
    public static final String GET_TRACKS_URL = "https://members-ng.iracing.com/data/track/get";
    public static final String GET_TRACK_ASSETS_URL = "https://members-ng.iracing.com/data/track/assets";
    public static final String GET_DIVISIONS_URL = "https://members-ng.iracing.com/data/constants/divisions";
    public static final String GET_LICENSES_URL = "https://members-ng.iracing.com/data/lookup/licenses";
    public static final String GET_SEASONS_URL = "https://members-ng.iracing.com/data/series/seasons";
    public static final String GET_SUBSESSIONRESULT_URL = "https://members-ng.iracing.com/data/results/get";
    public static final String GET_LAPCHART_DATA_URL = "https://members-ng.iracing.com/data/results/lap_chart_data";
    public static final String GET_LAP_DATA_URL = "https://members-ng.iracing.com/data/results/lap_data";
    public static final String GET_SEASON_RESULTS_URL = "https://members-ng.iracing.com/data/results/season_results";

    // Date and time format constants for json deserialization
    public static final String UTC_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
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
