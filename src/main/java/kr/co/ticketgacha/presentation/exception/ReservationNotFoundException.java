package kr.co.ticketgacha.presentation.exception;

public class ReservationNotFoundException extends RuntimeException{
    public ReservationNotFoundException() {
        super();
    }

    public ReservationNotFoundException(String message) {
        super(message);
    }

    public ReservationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReservationNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ReservationNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
