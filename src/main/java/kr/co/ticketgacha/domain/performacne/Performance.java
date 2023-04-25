package kr.co.ticketgacha.domain.performacne;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import kr.co.ticketgacha.domain.auditorium.Auditorium;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Performance {
    @Id
    @GeneratedValue
    private Long performanceId;
    @ManyToOne
    @JoinColumn(name = "AUDITORIUM_ID")
    private Auditorium auditorium;
    @Column
    private String name;
    @Column
    private LocalDateTime start;
    @Column
    private LocalDateTime end;
    @Column
    private boolean deleted;
    @Column
    @CreatedDate
    private LocalDateTime createdAt;
    @Column
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    public Performance(Auditorium auditorium, String name, LocalDateTime start, LocalDateTime end, boolean deleted) {
        this.auditorium = auditorium;
        this.name = name;
        this.start = start;
        this.end = end;
        this.deleted = deleted;
    }
}
