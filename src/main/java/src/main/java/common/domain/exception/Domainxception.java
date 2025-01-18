package src.main.java.common.domain.exception;

public class Domainxception extends RuntimeException {

    public Domainxception(String message) {
        super(message);
    }

    public Domainxception(String message, Throwable cause) {
        super(message, cause);
    }

}
