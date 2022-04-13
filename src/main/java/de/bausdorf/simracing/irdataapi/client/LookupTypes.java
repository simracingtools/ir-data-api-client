package de.bausdorf.simracing.irdataapi.client;

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

import java.util.List;

public enum LookupTypes {
    LICENSE_LEVELS("licenselevels", List.of("licenselevels")),
    WEATHER("weather", List.of(
            "weather_temp_units",
            "weather_temp_max",
            "weather_temp_min",
            "weather_wind_speed_units",
            "weather_wind_speed_min",
            "weather_wind_speed_max"
            ));

    private final String lookupTag;
    private final List<String> lookupSubtypes;

    LookupTypes(String lookupTag, List<String> lookupSubtypes) {
        this.lookupTag = lookupTag;
        this.lookupSubtypes = lookupSubtypes;
    }

    public String tag() {
        return lookupTag;
    }

    public List<String> types() {
        return lookupSubtypes;
    }

    public String toUrlParameters() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < lookupSubtypes.size(); i++) {
            if (i > 0) {
                sb.append('&');
            }
            sb.append(lookupTag).append('=').append(lookupSubtypes.get(i));
        }

        return sb.toString();
    }
}
