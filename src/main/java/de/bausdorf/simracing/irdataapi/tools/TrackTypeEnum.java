package de.bausdorf.simracing.irdataapi.tools;

import org.springframework.lang.NonNull;

public enum TrackTypeEnum {
    OVAL(Constants.OVAL),
    ROAD(Constants.ROAD),
    DIRT_OVAL(Constants.DIRT_OVAL),
    DIRT_ROAD(Constants.DIRT_ROAD);

    private final String name;

    TrackTypeEnum(String trackTypeName) {
        this.name = trackTypeName;
    }

    public static TrackTypeEnum forName(@NonNull String trackTypeName) {
        if(trackTypeName.equalsIgnoreCase(Constants.ROAD))
            return ROAD;
        else if(trackTypeName.equalsIgnoreCase(Constants.OVAL))
            return OVAL;
        else if(trackTypeName.equalsIgnoreCase(Constants.DIRT_ROAD))
            return DIRT_ROAD;
        else if(trackTypeName.equalsIgnoreCase(Constants.DIRT_OVAL))
            return DIRT_OVAL;
        else
            throw new IllegalArgumentException("\"" + trackTypeName + "\" is an unknown track type name");
    }

    @Override
    public String toString() {
        return this.name;
    }
}
