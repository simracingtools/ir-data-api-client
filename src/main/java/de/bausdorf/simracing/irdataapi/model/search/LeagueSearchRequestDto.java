package de.bausdorf.simracing.irdataapi.model.search;

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

public class LeagueSearchRequestDto extends SearchRequestDto {
    private final SearchParameter<Boolean> restrictToMember;
    private final SearchParameter<Boolean> restrictToRecruiting;
    private final SearchParameter<Boolean> restrictToFriends;
    private final SearchParameter<Boolean> restrictToWatched;
    private final SearchParameter<Long> minimumRosterCount;
    private final SearchParameter<Long> maximumRosterCount;
    private final SearchParameter<LeagueSortType> sort;
    private final SearchParameter<Long> lowerBound;
    private final SearchParameter<Long> upperBound;
    private final SearchParameter<String> search;
    private final SearchParameter<OrderType> order;


    private LeagueSearchRequestDto() {
        super();
        this.maximumRosterCount = new SearchParameter<>("maximum_roster_count");
        this.minimumRosterCount = new SearchParameter<>("minimum_roster_count");
        this.restrictToFriends = new SearchParameter<>("restrict_to_friends");
        this.restrictToMember = new SearchParameter<>("restrict_to_member");
        this.restrictToRecruiting = new SearchParameter<>("restrict_to_recruiting");
        this.restrictToWatched = new SearchParameter<>("restrict_to_watched");
        this.sort = new SearchParameter<>("sort");
        this.upperBound = new SearchParameter<>("upperbound");
        this.lowerBound = new SearchParameter<>("lowerbound");
        this.search = new SearchParameter<>("search");
        this.order = new SearchParameter<>("order");
    }

    public static LeagueSearchRequestDto create() {
        return new LeagueSearchRequestDto();
    }

    public LeagueSearchRequestDto withSort(LeagueSortType sortType) {
        this.sort.setParameterValue(sortType);
        return this;
    }

    public LeagueSearchRequestDto withMaximumRosterCount(Long maximumRosterCount) {
        this.maximumRosterCount.setParameterValue(maximumRosterCount);
        return this;
    }

    public LeagueSearchRequestDto withMinimumRosterCount(Long minimumRosterCount) {
        this.minimumRosterCount.setParameterValue(minimumRosterCount);
        return this;
    }

    public LeagueSearchRequestDto withRestrictToFriends(Boolean restrictToFriends) {
        this.restrictToFriends.setParameterValue(restrictToFriends);
        return this;
    }

    public LeagueSearchRequestDto withRestrictToWatched(Boolean restrictToWatched) {
        this.restrictToWatched.setParameterValue(restrictToWatched);
        return this;
    }

    public LeagueSearchRequestDto withRestrictToMember(Boolean restrictToMember) {
        this.restrictToMember.setParameterValue(restrictToMember);
        return this;
    }

    public LeagueSearchRequestDto withRestrictToRecruiting(Boolean restrictToRecruiting) {
        this.restrictToRecruiting.setParameterValue(restrictToRecruiting);
        return this;
    }

    public LeagueSearchRequestDto withLowerBound(Long lowerBound) {
        this.lowerBound.setParameterValue(lowerBound);
        return this;
    }

    public LeagueSearchRequestDto withUpperBound(Long upperBound) {
        this.upperBound.setParameterValue(upperBound);
        return this;
    }

    public LeagueSearchRequestDto withSearch(String search) {
        this.search.setParameterValue(search);
        return this;
    }

    public LeagueSearchRequestDto withOrder(OrderType orderType) {
        this.order.setParameterValue(orderType);
        return this;
    }

    @Override
    protected String toParameterString() {
        return lowerBound.toUrlParameter()
                + upperBound.toUrlParameter()
                + search.toUrlParameter()
                + order.toUrlParameter()
                + sort.toUrlParameter()
                + restrictToWatched.toUrlParameter()
                + restrictToRecruiting.toUrlParameter()
                + restrictToMember.toUrlParameter()
                + restrictToFriends.toUrlParameter()
                + minimumRosterCount.toUrlParameter()
                + maximumRosterCount.toUrlParameter();
    }
}
