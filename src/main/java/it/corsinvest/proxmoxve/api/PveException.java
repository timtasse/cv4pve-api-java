package it.corsinvest.proxmoxve.api;

/**
 * Created by Stefan Dilk {@literal <stefan.dilk@freenet.ag>} on 05.09.25.
 */
public class PveException extends RuntimeException {

    public PveException(String message) {
        super(message);
    }
    public PveException(String message, Throwable cause) {
        super(message, cause);
    }
}
