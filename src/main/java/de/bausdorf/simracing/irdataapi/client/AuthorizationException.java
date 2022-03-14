package de.bausdorf.simracing.irdataapi.client;

public class AuthorizationException extends RuntimeException {

    public AuthorizationException(String message) {
        super(message);
    }

    public AuthorizationException(Throwable e) {
        super(e);
    }
}
