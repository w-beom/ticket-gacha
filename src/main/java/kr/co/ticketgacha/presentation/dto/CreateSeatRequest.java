package kr.co.ticketgacha.presentation.dto;

import kr.co.ticketgacha.domain.seat.Status;
import lombok.Getter;

@Getter
public class CreateSeatRequest {
    private Long auditoriumId;
    private String row;
    private String col;
    private Status status;
}
