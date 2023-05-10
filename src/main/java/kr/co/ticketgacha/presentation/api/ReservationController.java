package kr.co.ticketgacha.presentation.api;

import jakarta.validation.Valid;
import kr.co.ticketgacha.application.ReservationService;
import kr.co.ticketgacha.domain.reservation.Reservation;
import kr.co.ticketgacha.presentation.dto.request.CreateReservationRequest;
import kr.co.ticketgacha.presentation.dto.response.ReservationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponse> findReservation(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.findReservation(id));
    }

    @PutMapping("cancel/{id}")
    public ResponseEntity<Void> cancelReservation(@PathVariable Long id) {
        reservationService.cancelReservation(id);
        return ResponseEntity.ok().build();
    }
}
