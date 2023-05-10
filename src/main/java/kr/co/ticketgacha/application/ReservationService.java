package kr.co.ticketgacha.application;

import kr.co.ticketgacha.domain.Member;
import kr.co.ticketgacha.domain.MemberRepository;
import kr.co.ticketgacha.domain.performance.Performance;
import kr.co.ticketgacha.domain.performance.PerformanceRepository;
import kr.co.ticketgacha.domain.reservation.ReservationStatus;
import kr.co.ticketgacha.domain.seat.Seat;
import kr.co.ticketgacha.domain.seat.SeatRepository;
import kr.co.ticketgacha.domain.reservation.Reservation;
import kr.co.ticketgacha.domain.reservation.ReservationRepository;
import kr.co.ticketgacha.presentation.dto.request.CreateReservationRequest;
import kr.co.ticketgacha.presentation.dto.response.PerformanceResponse;
import kr.co.ticketgacha.presentation.dto.response.ReservationResponse;
import kr.co.ticketgacha.presentation.dto.response.SeatResponse;
import kr.co.ticketgacha.presentation.exception.MemberNotFoundException;
import kr.co.ticketgacha.presentation.exception.PerformanceNotFoundException;
import kr.co.ticketgacha.presentation.exception.ReservationNotFoundException;
import kr.co.ticketgacha.presentation.exception.SeatAlreadyReservedException;
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

        if (seat.isUsed()) {
            throw new SeatAlreadyReservedException();
        }

        Reservation reservation = Reservation.builder()
                .member(member)
                .reservationDate(requestDto.getReservationDate())
                .seat(seat)
                .reservationStatus(ReservationStatus.WAITING)
                .performance(performance)
                .build();

        reservationRepository.save(reservation);

        // 좌석을 사용한상태로 수정한다.
        seat.used();
        seatRepository.save(seat);
    }

    public ReservationResponse findReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(ReservationNotFoundException::new);

        Performance performance = reservation.getPerformance();
        Seat seat = reservation.getSeat();

        return ReservationResponse.builder()
                .reservationId(reservation.getReservationId())
                .memberId(reservation.getMember().getMemberId())
                .reservationDate(reservation.getReservationDate())
                .performance(PerformanceResponse.builder()
                        .performanceId(performance.getPerformanceId())
                        .performanceName(performance.getName())
                        .deleted(performance.isDeleted())
                        .startDate(performance.getStart())
                        .endDate(performance.getEnd())
                        .build())
                .seat(SeatResponse.builder()
                        .seatId(seat.getSeatId())
                        .row(seat.getRow())
                        .col(seat.getCol())
                        .seatStatus(seat.getSeatStatus())
                        .build())
                .build();
    }

    @Transactional
    public void cancelReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(ReservationNotFoundException::new);

        Seat seat = reservation.getSeat();

        reservation.cancel();
        reservationRepository.save(reservation);

        seat.unUsed();
        seatRepository.save(seat);
    }
}
