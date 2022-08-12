package de.bausdorf.simracing.irdataapi.tools;

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

import org.springframework.lang.NonNull;

public enum TrackType {
    OVAL(Constants.OVAL),
    ROAD(Constants.ROAD),
    DIRT_OVAL(Constants.DIRT_OVAL),
    DIRT_ROAD(Constants.DIRT_ROAD);

    private final String name;

    TrackType(String trackTypeName) {
        this.name = trackTypeName;
    }

    public static TrackType forName(@NonNull String trackTypeName) {
        if (trackTypeName.equalsIgnoreCase(Constants.ROAD))
            return ROAD;
        else if (trackTypeName.equalsIgnoreCase(Constants.OVAL))
            return OVAL;
        else if (trackTypeName.equalsIgnoreCase(Constants.DIRT_ROAD))
            return DIRT_ROAD;
        else if (trackTypeName.equalsIgnoreCase(Constants.DIRT_OVAL))
            return DIRT_OVAL;
        else
            throw new IllegalArgumentException("\"" + trackTypeName + "\" is an unknown track type name");
    }

    @Override
    public String toString() {
        return this.name;
    }
}
