package kr.co.ticketgacha.presentation.api;

import kr.co.ticketgacha.application.SeatService;
import kr.co.ticketgacha.presentation.dto.CreateSeatRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "seat/")
@RequiredArgsConstructor
public class SeatController {

    private final SeatService seatService;

    public ResponseEntity<Void> createSeat(@RequestBody CreateSeatRequest createSeatRequest) {
        seatService.createSeat(createSeatRequest);
        return ResponseEntity.ok().build();
    }
}
