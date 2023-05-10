package kr.co.ticketgacha.presentation.dto.request;

import kr.co.ticketgacha.domain.seat.SeatStatus;
import lombok.Getter;

@Getter
public class CreateSeatRequest {
    private Long auditoriumId;
    private String row;
    private String col;
    private SeatStatus seatStatus;
}
