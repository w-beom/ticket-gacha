package kr.co.ticketgacha.domain.seat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import kr.co.ticketgacha.domain.auditorium.Auditorium;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seat {
    @Id
    private Long seatId;
    @ManyToOne
    @JoinColumn(name = "AUDITORIUM_ID")
    private Auditorium auditorium;
    @Column
    private String row;
    @Column
    private String col;
    @Column
    private Status status;
    @Column
    @CreatedDate
    private LocalDateTime createdAt;
    @Column
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    public Seat(Auditorium auditorium, String row, String col, Status status) {
        this.auditorium = auditorium;
        this.row = row;
        this.col = col;
        this.status = status;
    }

    public void used() {
        this.status = Status.USED;
    }
}
