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

import java.util.List;

public class Constants {

    // Track/car type names
    public static final String OVAL = "oval";
    public static final String ROAD = "road";
    public static final String DIRT = "dirt";
    public static final String DIRT_OVAL = "dirt_oval";
    public static final String DIRT_ROAD = "dirt_road";

    public static final String CAT_ROAD = ROAD;
    public static final String CAT_OVAL = OVAL;

    public static final String GT1 = "gt1";
    public static final String GT3 = "gt3";
    public static final String GT4 = "gt4";
    public static final String GTD = "gtd";
    public static final String GTE = "gte";
    public static final String GTLM = "gtlm";
    public static final String IMSA = "imsa";
    public static final String LMP1 = "lmp1";
    public static final String LMP2 = "lmp2";
    public static final String TCR = "tcr";
    public static final List<String> CAR_SUBTYPES = List.of(GT1, GTE, GT3, GT4, GTD, GTLM, IMSA, LMP1, LMP2, TCR);

    private Constants() {
        super();
    }
}
