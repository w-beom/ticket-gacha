package kr.co.ticketgacha.presentation.dto.request;

import jakarta.annotation.Nonnull;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateReservationRequest {
    @Nonnull
    private Long performanceId;
    @Nonnull
    private Long memberId;
    @Nonnull
    private Long seatId;
    @Nonnull
    private LocalDateTime reservationDate;

    @Builder
    public CreateReservationRequest(Long performanceId, Long memberId, Long seatId, LocalDateTime reservationDate) {
        this.performanceId = performanceId;
        this.memberId = memberId;
        this.seatId = seatId;
        this.reservationDate = reservationDate;
    }
}
