package kr.co.ticketgacha.presentation.exception;

public class AuditoriumNotFoundException extends RuntimeException {
    public AuditoriumNotFoundException() {
    }

    public AuditoriumNotFoundException(String message) {
        super(message);
    }

    public AuditoriumNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuditoriumNotFoundException(Throwable cause) {
        super(cause);
    }

    public AuditoriumNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
