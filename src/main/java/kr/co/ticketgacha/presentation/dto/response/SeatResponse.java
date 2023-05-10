package kr.co.ticketgacha.presentation.dto.response;

import kr.co.ticketgacha.domain.seat.SeatStatus;
import lombok.Builder;

public class SeatResponse {
    private Long seatId;
    private Long auditoriumId;
    private String row;
    private String col;
    private SeatStatus seatStatus;

    @Builder
    public SeatResponse(Long seatId, Long auditoriumId, String row, String col, SeatStatus seatStatus) {
        this.seatId = seatId;
        this.auditoriumId = auditoriumId;
        this.row = row;
        this.col = col;
        this.seatStatus = seatStatus;
    }
}
