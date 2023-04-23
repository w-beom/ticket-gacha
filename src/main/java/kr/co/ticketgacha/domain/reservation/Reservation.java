package kr.co.ticketgacha.domain.reservation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import kr.co.ticketgacha.domain.Member;
import kr.co.ticketgacha.domain.Performance;
import kr.co.ticketgacha.domain.seat.Seat;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation {
    @Id
    private Long reservationId;
    @ManyToOne
    @JoinColumn(name = "PERFORMANCE_ID")
    private Performance performance;
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "SEAT_ID")
    private Seat seat;
    @Column
    private LocalDateTime reservationDate;
    @Column
    private Status status;
    @Column
    @CreatedDate
    private LocalDateTime createdAt;
    @Column
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    public Reservation(Performance performance, Member member, Seat seat, LocalDateTime reservationDate, Status status) {
        this.performance = performance;
        this.member = member;
        this.seat = seat;
        this.reservationDate = reservationDate;
        this.status = status;
    }
}
