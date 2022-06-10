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

import de.bausdorf.simracing.irdataapi.client.EventType;

import java.util.List;

public class SeriesResultSearchRequest extends ResultSearchRequest {
    private final SearchParameter<Integer> seasonYear;
    private final SearchParameter<Integer> seasonQuarter;
    private final SearchParameter<Long> seriesId;
    private final SearchParameter<Integer> raceWeekNum;
    private final SearchParameter<Boolean> officialOnly;
    // Types of events to include in the search. Defaults to all. ?event_types=2,3,4,5
    private final EventListSearchParameter eventTypes;

    protected SeriesResultSearchRequest() {
        super();
        this.seasonYear = new SearchParameter<>("season_year");
        this.seasonQuarter = new SearchParameter<>("season_quarter");
        this.seriesId = new SearchParameter<>("series_id");
        this.raceWeekNum = new SearchParameter<>("race_week_num");
        this.officialOnly = new SearchParameter<>("official_only");
        this.eventTypes = new EventListSearchParameter("event_types");
    }

    public SeriesResultSearchRequest withSeasonYear(Integer seasonYear) {
        this.seasonYear.setParameterValue(seasonYear);
        return this;
    }

    public SeriesResultSearchRequest withSeasonQuarter(Integer seasonQuarter) {
        this.seasonQuarter.setParameterValue(seasonQuarter);
        return this;
    }

    public SeriesResultSearchRequest withSeriesId(Long seriesId) {
        this.seriesId.setParameterValue(seriesId);
        return this;
    }

    public SeriesResultSearchRequest withRaceWeekNum(Integer raceWeekNum) {
        this.raceWeekNum.setParameterValue(raceWeekNum);
        return this;
    }

    public SeriesResultSearchRequest withOfficialOnly(Boolean officialOnly) {
        this.officialOnly.setParameterValue(officialOnly);
        return this;
    }

    public SeriesResultSearchRequest withEventTypes(List<EventType> eventTypes) {
        this.eventTypes.setParameterValue(eventTypes);
        return this;
    }

    public static SeriesResultSearchRequest create() {
        return new SeriesResultSearchRequest();
    }

    @Override
    protected String toParameterString() {
        return super.toParameterString()
                + seasonYear.toUrlParameter()
                + seasonQuarter.toUrlParameter()
                + seriesId.toUrlParameter()
                + raceWeekNum.toUrlParameter()
                + officialOnly.toUrlParameter()
                + eventTypes.toUrlParameter();
    }
}
