package de.bausdorf.simracing.irdataapi.client;

public enum CategoryType {
    OVAL(1),
    ROAD(2),
    DIRT_OVAL(3),
    DIRT_ROAD(4);

    private final int code;

    CategoryType(int code) {
        this.code = code;
    }

    public String toCode() {
        return Integer.toString(code);
    }
}
