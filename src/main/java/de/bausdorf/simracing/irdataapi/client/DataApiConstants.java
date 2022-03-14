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

    public static final String AUTH_URL = "https://members-ng.iracing.com/auth";
    public static final String GET_MEMBERS_URL = "https://members-ng.iracing.com/data/member/get";
    public static final String GET_CARS_URL = "https://members-ng.iracing.com/data/car/get";
    public static final String GET_CAR_ASSETS_URL = "https://members-ng.iracing.com/data/car/assets";
    public static final String GET_LEAGUE_URL = "https://members-ng.iracing.com/data/league/get";
    public static final String GET_TRACKS_URL = "https://members-ng.iracing.com/data/track/get";

    private DataApiConstants() {
        super();
    }
}
