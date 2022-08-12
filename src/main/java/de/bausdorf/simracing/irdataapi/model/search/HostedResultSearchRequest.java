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

public class HostedResultSearchRequest extends ResultSearchRequest {
    // Part or all of the session's name.
    private final SearchParameter<String> sessioName;
    private final SearchParameter<Long> hostCustId;
    private final SearchParameter<Long> leagueId;
    private final SearchParameter<Long> leagueSeasonId;
    private final SearchParameter<Long> carId;
    private final SearchParameter<Long> trackId;

    private HostedResultSearchRequest() {
        super();
        this.sessioName = new SearchParameter<>("session_name");
        this.hostCustId = new SearchParameter<>("host_cust_id");
        this.leagueId = new SearchParameter<>("league_id");
        this.leagueSeasonId = new SearchParameter<>("league_season_id");
        this.carId = new SearchParameter<>("car_id");
        this.trackId = new SearchParameter<>("track_id");
    }

    public HostedResultSearchRequest withSessionName(String sessionName) {
        this.sessioName.setParameterValue(sessionName);
        return this;
    }

    public HostedResultSearchRequest withHostCustId(Long id) {
        this.hostCustId.setParameterValue(id);
        return this;
    }

    public HostedResultSearchRequest withLeagueId(Long id) {
        this.leagueId.setParameterValue(id);
        return this;
    }

    public HostedResultSearchRequest withLeagueSeasonId(Long id) {
        this.leagueSeasonId.setParameterValue(id);
        return this;
    }

    public HostedResultSearchRequest withCarId(Long id) {
        this.carId.setParameterValue(id);
        return this;
    }

    public HostedResultSearchRequest withTrackId(Long id) {
        this.trackId.setParameterValue(id);
        return this;
    }

    public static HostedResultSearchRequest create() {
        return new HostedResultSearchRequest();
    }

    @Override
    protected String toParameterString() {
        return super.toParameterString()
                + this.sessioName.toUrlParameter()
                + this.hostCustId.toUrlParameter()
                + this.leagueId.toUrlParameter()
                + this.carId.toUrlParameter()
                + this.trackId.toUrlParameter()
                + this.leagueSeasonId.toUrlParameter();
    }
}
