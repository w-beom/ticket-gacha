package kr.co.ticketgacha.domain.reservation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import kr.co.ticketgacha.domain.Member;
import kr.co.ticketgacha.domain.performance.Performance;
import kr.co.ticketgacha.domain.seat.Seat;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Reservation {
    @Id
    private Long reservationId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PERFORMANCE_ID")
    private Performance performance;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SEAT_ID")
    private Seat seat;
    @Column
    private LocalDateTime reservationDate;
    @Column
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;
    @Column
    @CreatedDate
    private LocalDateTime createdAt;
    @Column
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    public Reservation(Performance performance, Member member, Seat seat, LocalDateTime reservationDate, ReservationStatus reservationStatus) {
        this.performance = performance;
        this.member = member;
        this.seat = seat;
        this.reservationDate = reservationDate;
        this.reservationStatus = reservationStatus;
    }

    public void cancel() {
        this.reservationStatus = ReservationStatus.CANCEL;
    }
}
