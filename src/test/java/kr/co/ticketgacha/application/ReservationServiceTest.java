package kr.co.ticketgacha.application;

import kr.co.ticketgacha.domain.Member;
import kr.co.ticketgacha.domain.MemberRepository;
import kr.co.ticketgacha.domain.auditorium.Auditorium;
import kr.co.ticketgacha.domain.performance.Performance;
import kr.co.ticketgacha.domain.performance.PerformanceRepository;
import kr.co.ticketgacha.domain.reservation.ReservationRepository;
import kr.co.ticketgacha.domain.seat.SeatRepository;
import kr.co.ticketgacha.infrastructure.FakeMemberRepository;
import kr.co.ticketgacha.infrastructure.FakePerformanceRepository;
import kr.co.ticketgacha.infrastructure.FakeReservationRepository;
import kr.co.ticketgacha.infrastructure.FakeSeatRepository;
import kr.co.ticketgacha.presentation.dto.request.CreateReservationRequest;
import kr.co.ticketgacha.presentation.exception.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReservationServiceTest {
    private ReservationService reservationService;
    private PerformanceRepository performanceRepository = new FakePerformanceRepository();
    private ReservationRepository reservationRepository = new FakeReservationRepository();
    private MemberRepository memberRepository = new FakeMemberRepository();
    private SeatRepository seatRepository = new FakeSeatRepository();


    @BeforeEach
    public void before() {
        reservationService = new ReservationService(reservationRepository, memberRepository, performanceRepository, seatRepository);
    }

    @Test
    @DisplayName("등록되어있는 회원이 없으면 MemberNotFoundException이 발생한다.")
    void memberNotFoundExceptionTest() {
        CreateReservationRequest request = CreateReservationRequest.builder()
                .memberId(1L)
                .performanceId(1L)
                .seatId(1L)
                .reservationDate(LocalDateTime.now())
                .build();

        assertThrowsExactly(EntityNotFoundException.class, () -> reservationService.reservation(request));
    }

    @Test
    @DisplayName("등록되어있는 좌석이 공연이 없으면 PerformanceNotFoundException이 발생한다.")
    void performanceNotFoundExceptionTest() {
        Member member = Member.builder()
                .id("ID")
                .name("name")
                .phone("01029780961")
                .pw("pw")
                .email("email")
                .admin(false)
                .build();

        memberRepository.save(member);

        //given
        CreateReservationRequest request = CreateReservationRequest.builder()
                .memberId(1L)
                .performanceId(1L)
                .seatId(1L)
                .reservationDate(LocalDateTime.now())
                .build();

        assertThrowsExactly(EntityNotFoundException.class, () -> reservationService.reservation(request));
    }

    @Test
    @DisplayName("등록되어있는 좌석이 없으면 seatNotFoundException 이발생한다.")
    void seatNotFoundException() {
        Member member = Member.builder()
                .id("ID")
                .name("name")
                .phone("01029780961")
                .pw("pw")
                .email("email")
                .admin(false)
                .build();

        Performance performance = Performance.builder()
                .auditorium(new Auditorium())
                .start(LocalDateTime.now())
                .end(LocalDateTime.now())
                .deleted(false)
                .build();

        memberRepository.save(member);
        performanceRepository.save(performance);

        CreateReservationRequest request = CreateReservationRequest.builder()
                .memberId(1L)
                .performanceId(1L)
                .seatId(1L)
                .reservationDate(LocalDateTime.now())
                .build();

        assertThrowsExactly(EntityNotFoundException.class, () -> reservationService.reservation(request));
    }
}
