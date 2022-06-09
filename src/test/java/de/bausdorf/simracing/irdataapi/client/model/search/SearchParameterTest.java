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

import de.bausdorf.simracing.irdataapi.model.search.LeagueSearchRequestDto;
import de.bausdorf.simracing.irdataapi.model.search.LeagueSortType;
import de.bausdorf.simracing.irdataapi.model.search.OrderType;
import de.bausdorf.simracing.irdataapi.model.search.SearchRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class SearchParameterTest {

    private static String EXPECTED_FULL_PARAMETER = "?lowerbound=1&upperbound=10&search=Racing&order=asc&sort=rostercount&restrict_to_watched=false&restrict_to_recruiting=true&restrict_to_member=false&restrict_to_friends=false&minimum_roster_count=10&maximum_roster_count=100";
    private static String EXPECTED_PARTIAL_PARAMETER = "?lowerbound=1&upperbound=100";

    @Test
    void testLeagueSearchRequestFull() {
        SearchRequestDto requestDto = LeagueSearchRequestDto.create()
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
        assertEquals(EXPECTED_FULL_PARAMETER, queryString);
    }

    @Test
    void testLeagueSearchRequestPartial() {
        SearchRequestDto requestDto = LeagueSearchRequestDto.create()
                .withLowerBound(1L)
                .withUpperBound(100L);

        String queryString = requestDto.toQueryString();
        log.info(queryString);
        assertEquals('?', queryString.charAt(0));
        assertEquals(EXPECTED_PARTIAL_PARAMETER, queryString);
    }

    @Test
    void testLeagueSearchRequestEmpty() {
        SearchRequestDto requestDto = LeagueSearchRequestDto.create();
        String queryString = requestDto.toQueryString();
        log.info(queryString);
        assertEquals("", queryString);
    }
}
