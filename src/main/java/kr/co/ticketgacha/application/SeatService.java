package kr.co.ticketgacha.application;

import kr.co.ticketgacha.domain.auditorium.Auditorium;
import kr.co.ticketgacha.domain.auditorium.AuditoriumRepository;
import kr.co.ticketgacha.domain.seat.Seat;
import kr.co.ticketgacha.domain.seat.SeatRepository;
import kr.co.ticketgacha.presentation.dto.CreateSeatRequest;
import kr.co.ticketgacha.presentation.exception.AuditoriumNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final SeatRepository seatRepository;
    private final AuditoriumRepository auditoriumRepository;

    @Transactional
    public void createSeat(CreateSeatRequest createSeatRequest) {
        Auditorium auditorium = auditoriumRepository.findById(createSeatRequest.getAuditoriumId())
                .orElseThrow(AuditoriumNotFoundException::new);

        Seat seat = Seat.builder()
                .auditorium(auditorium)
                .col(createSeatRequest.getCol())
                .row(createSeatRequest.getRow())
                .status(createSeatRequest.getStatus())
                .build();

        seatRepository.save(seat);
    }
}
