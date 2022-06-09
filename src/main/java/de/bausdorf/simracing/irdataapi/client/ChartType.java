package de.bausdorf.simracing.irdataapi.client;

public enum ChartType {
    I_RATING(1),
    TT_RATING(2),
    LICENSE_SR(3);

    private final int code;

    ChartType(int code) {
        this.code = code;
    }

    public String toCode() {
        return Integer.toString(code);
    }
}
