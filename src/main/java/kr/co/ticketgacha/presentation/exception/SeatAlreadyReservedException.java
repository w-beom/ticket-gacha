package kr.co.ticketgacha.presentation.exception;

public class SeatAlreadyReservedException extends RuntimeException {
    public SeatAlreadyReservedException() {
    }

    public SeatAlreadyReservedException(String message) {
        super(message);
    }

    public SeatAlreadyReservedException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeatAlreadyReservedException(Throwable cause) {
        super(cause);
    }

    public SeatAlreadyReservedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
