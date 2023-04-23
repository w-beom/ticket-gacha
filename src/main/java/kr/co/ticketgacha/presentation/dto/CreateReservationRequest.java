package kr.co.ticketgacha.presentation.dto;

import jakarta.annotation.Nonnull;
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
}
