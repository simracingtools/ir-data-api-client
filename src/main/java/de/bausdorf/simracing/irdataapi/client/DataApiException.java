package de.bausdorf.simracing.irdataapi.client;

public class DataApiException extends RuntimeException {

    public DataApiException(String message) {
        super(message);
    }

    public DataApiException(Throwable e) {
        super(e);
    }
}
