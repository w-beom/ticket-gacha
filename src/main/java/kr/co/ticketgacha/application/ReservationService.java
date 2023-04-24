package kr.co.ticketgacha.application;

import kr.co.ticketgacha.domain.Member;
import kr.co.ticketgacha.domain.MemberRepository;
import kr.co.ticketgacha.domain.Performance;
import kr.co.ticketgacha.domain.PerformanceRepository;
import kr.co.ticketgacha.domain.reservation.Status;
import kr.co.ticketgacha.domain.seat.Seat;
import kr.co.ticketgacha.domain.seat.SeatRepository;
import kr.co.ticketgacha.domain.reservation.Reservation;
import kr.co.ticketgacha.domain.reservation.ReservationRepository;
import kr.co.ticketgacha.presentation.dto.CreateReservationRequest;
import kr.co.ticketgacha.presentation.exception.MemberNotFoundException;
import kr.co.ticketgacha.presentation.exception.PerformanceNotFoundException;
import kr.co.ticketgacha.presentation.exception.SeatNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final MemberRepository memberRepository;
    private final PerformanceRepository performanceRepository;
    private final SeatRepository seatRepository;

    @Transactional
    public void reservation(CreateReservationRequest requestDto) {
        Member member = memberRepository.findById(requestDto.getMemberId())
                .orElseThrow(MemberNotFoundException::new);

        Performance performance = performanceRepository.findById(requestDto.getPerformanceId())
                .orElseThrow(PerformanceNotFoundException::new);

        Seat seat = seatRepository.findById(requestDto.getSeatId())
                .orElseThrow(SeatNotFoundException::new);

        Reservation reservation = Reservation.builder()
                .member(member)
                .reservationDate(requestDto.getReservationDate())
                .seat(seat)
                .status(Status.WAITING)
                .performance(performance)
                .build();

        reservationRepository.save(reservation);

        // 좌석을 사용한상태로 수정한다.
        seat.used();
        seatRepository.save(seat);
    }
}
