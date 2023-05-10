package kr.co.ticketgacha.presentation.dto.response;

import kr.co.ticketgacha.domain.reservation.ReservationStatus;
import lombok.Builder;

import java.time.LocalDateTime;

public class ReservationResponse {
    private Long reservationId;
    private Long memberId;
    private LocalDateTime reservationDate;
    private ReservationStatus reservationStatus;
    private PerformanceResponse performance;
    private SeatResponse seat;

    @Builder
    public ReservationResponse(Long reservationId, Long memberId, LocalDateTime reservationDate, ReservationStatus reservationStatus, PerformanceResponse performance, SeatResponse seat) {
        this.reservationId = reservationId;
        this.memberId = memberId;
        this.reservationDate = reservationDate;
        this.reservationStatus = reservationStatus;
        this.performance = performance;
        this.seat = seat;
    }
}
