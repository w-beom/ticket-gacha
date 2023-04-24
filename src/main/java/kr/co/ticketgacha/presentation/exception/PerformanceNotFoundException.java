package kr.co.ticketgacha.presentation.exception;

public class PerformanceNotFoundException extends RuntimeException{

    public PerformanceNotFoundException() {
        super();
    }

    public PerformanceNotFoundException(String message) {
        super(message);
    }

    public PerformanceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PerformanceNotFoundException(Throwable cause) {
        super(cause);
    }

    protected PerformanceNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
