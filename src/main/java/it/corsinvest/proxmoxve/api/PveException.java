package it.corsinvest.proxmoxve.api;

public class PveException extends RuntimeException {

    public PveException(String message) {
        super(message);
    }
    public PveException(String message, Throwable cause) {
        super(message, cause);
    }
}
