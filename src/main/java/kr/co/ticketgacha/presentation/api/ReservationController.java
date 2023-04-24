package kr.co.ticketgacha.presentation.api;

import jakarta.validation.Valid;
import kr.co.ticketgacha.application.ReservationService;
import kr.co.ticketgacha.presentation.dto.CreateReservationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping(value = "")
    public ResponseEntity<Void> createReservation(@Valid CreateReservationRequest requestDto) {
        reservationService.reservation(requestDto);
        return ResponseEntity.ok().build();
    }
}
