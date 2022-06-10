package de.bausdorf.simracing.irdataapi.client.model.search;

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

import de.bausdorf.simracing.irdataapi.client.CategoryType;
import de.bausdorf.simracing.irdataapi.client.EventType;
import de.bausdorf.simracing.irdataapi.model.search.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class SearchParameterTest {

    private static final String EXPECTED_LEAGUE_SEARCH_FULL_PARAMETER = "?lowerbound=1&upperbound=10&search=Racing&order=asc&sort=rostercount&restrict_to_watched=false&restrict_to_recruiting=true&restrict_to_member=false&restrict_to_friends=false&minimum_roster_count=10&maximum_roster_count=100";
    private static final String EXPECTED_LEAGUE_SEARCH_PARTIAL_PARAMETER = "?lowerbound=1&upperbound=100";
    private static final String EXPECTED_HOSTED_RESULT_FULL_PARAMETER = "?start_range_begin=2021-12-31T23:00Z&start_range_end=2022-03-30T22:00Z&finish_range_begin=2021-12-31T23:00Z&finish_range_end=2022-03-30T22:00Z&cust_id=987654&category_ids=2&session_name=Test&host_cust_id=229021&league_id=1234&car_id=123&track_id=456&league_season_id=34532";
    private static final String EXPECTED_HOSTED_RESULT_PARTIAL_PARAMETER = "?start_range_begin=2021-12-31T23:00Z&start_range_end=2022-03-30T22:00Z&finish_range_begin=2021-12-31T23:00Z&finish_range_end=2022-03-30T22:00Z&cust_id=229021&category_ids=2";
    private static final String EXPECTED_SERIES_RESULT_FULL_PARAMETER = "?start_range_begin=2021-12-31T23:00Z&start_range_end=2022-03-30T22:00Z&finish_range_begin=2021-12-31T23:00Z&finish_range_end=2022-03-30T22:00Z&cust_id=987654&category_ids=2&season_year=2022&season_quarter=1&series_id=12345&race_week_num=1&official_only=true&event_types=5,3";
    private static final ZonedDateTime BEGIN_CET = ZonedDateTime.of(LocalDateTime.of(2022, Month.JANUARY, 1, 0, 0), ZoneId.of("CET"));
    private static final ZonedDateTime END_CET = ZonedDateTime.of(LocalDateTime.of(2022, Month.MARCH, 31, 0, 0), ZoneId.of("CET"));

    @Test
    void testLeagueSearchRequestFull() {
        SearchRequest requestDto = LeagueSearchRequest.create()
                .withRestrictToFriends(false)
                .withRestrictToMember(false)
                .withRestrictToRecruiting(true)
                .withRestrictToWatched(false)
                .withMaximumRosterCount(100L)
                .withMinimumRosterCount(10L)
                .withSort(LeagueSortType.ROSTER_COUNT)
                .withOrder(OrderType.ASC)
                .withSearch("Racing")
                .withLowerBound(1L)
                .withUpperBound(10L);

        String queryString = requestDto.toQueryString();
        log.info(queryString);
        assertEquals('?', queryString.charAt(0));
        assertEquals(EXPECTED_LEAGUE_SEARCH_FULL_PARAMETER, queryString);
    }

    @Test
    void testLeagueSearchRequestPartial() {
        SearchRequest requestDto = LeagueSearchRequest.create()
                .withLowerBound(1L)
                .withUpperBound(100L);

        String queryString = requestDto.toQueryString();
        log.info(queryString);
        assertEquals('?', queryString.charAt(0));
        assertEquals(EXPECTED_LEAGUE_SEARCH_PARTIAL_PARAMETER, queryString);
    }

    @Test
    void testLeagueSearchRequestEmpty() {
        SearchRequest requestDto = LeagueSearchRequest.create();
        String queryString = requestDto.toQueryString();
        log.info(queryString);
        assertEquals("", queryString);
    }

    @Test
    void testHostedResultSearchRequestFull() {
        ResultSearchRequest request = HostedResultSearchRequest.create()
                .withCarId(123L)
                .withTrackId(456L)
                .withHostCustId(229021L)
                .withLeagueId(1234L)
                .withLeagueSeasonId(34532L)
                .withSessionName("Test")
                .withCategories(List.of(CategoryType.ROAD))
                .withCustId(987654L)
                .withStartRangeBegin(BEGIN_CET)
                .withFinishRangeBegin(BEGIN_CET)
                .withFinishRangeEnd(END_CET)
                .withStartRangeEnd(END_CET)
                .withCategories(List.of(CategoryType.ROAD));

        String query = request.toQueryString();
        log.info(query);
        assertEquals(EXPECTED_HOSTED_RESULT_FULL_PARAMETER, query);
    }

    @Test
    void testHostedResultSearchRequestPartial() {
        ResultSearchRequest request = HostedResultSearchRequest.create()
                .withCustId(229021L)
                .withStartRangeBegin(BEGIN_CET)
                .withFinishRangeBegin(BEGIN_CET)
                .withFinishRangeEnd(END_CET)
                .withStartRangeEnd(END_CET)
                .withCategories(List.of(CategoryType.ROAD));

        String query = request.toQueryString();
        log.info(query);
        assertEquals(EXPECTED_HOSTED_RESULT_PARTIAL_PARAMETER, query);
    }

    @Test
    void testHostedResultSearchRequestEmpty() {
        ResultSearchRequest request = HostedResultSearchRequest.create();
        String queryString = request.toQueryString();
        log.info(queryString);
        assertEquals("", queryString);
    }

    @Test
    void testSeriesResultSearchRequestFull() {
        ResultSearchRequest request = SeriesResultSearchRequest.create()
                .withEventTypes(List.of(EventType.RACE, EventType.QUALIFY))
                .withOfficialOnly(true)
                .withRaceWeekNum(1)
                .withSeriesId(12345L)
                .withSeasonQuarter(1)
                .withSeasonYear(2022)
                .withCategories(List.of(CategoryType.ROAD))
                .withCustId(987654L)
                .withStartRangeBegin(BEGIN_CET)
                .withFinishRangeBegin(BEGIN_CET)
                .withFinishRangeEnd(END_CET)
                .withStartRangeEnd(END_CET)
                .withCategories(List.of(CategoryType.ROAD));

        String query = request.toQueryString();
        log.info(query);
        assertEquals(EXPECTED_SERIES_RESULT_FULL_PARAMETER, query);
    }

    @Test
    void testSeriesResultSearchRequestEmpty() {
        ResultSearchRequest request = SeriesResultSearchRequest.create();
        String queryString = request.toQueryString();
        log.info(queryString);
        assertEquals("", queryString);
    }

    @Test
    void testZonedDateTimeSearchParameter() {
        ZonedDateTime localZonedTime = ZonedDateTime.of(LocalDateTime.of(2022, Month.JUNE, 1, 12, 0), ZoneId.of("CET"));
        log.info("Local time: {}", localZonedTime);

        ZonedDateTimeSearchParameter searchParameter = new ZonedDateTimeSearchParameter("zoned-time-utc");
        searchParameter.setParameterValue(localZonedTime);

        String utcString = searchParameter.getParameterValue();
        log.info("Utc string: {}", utcString);
        assertEquals("2022-06-01T10:00Z", utcString);
    }

    @Test
    void testCategoryListSearchParameter() {
        CategoryListSearchParameter categories = new CategoryListSearchParameter("category_list");
        categories.setParameterValue(List.of(CategoryType.ROAD, CategoryType.DIRT_ROAD));

        String categoryString = categories.getParameterValue();
        log.info("categories parameter value: {}", categoryString);
        assertEquals("2,4", categoryString);
    }

    @Test
    void testEventTypeListSearchParameter() {
        EventListSearchParameter events = new EventListSearchParameter("event_types");
        events.setParameterValue(List.of(EventType.QUALIFY, EventType.RACE));

        String categoryString = events.getParameterValue();
        log.info("events parameter value: {}", categoryString);
        assertEquals("3,5", categoryString);
    }
}
