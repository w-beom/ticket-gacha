package kr.co.ticketgacha.domain.auditorium;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Auditorium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditoriumId;
    @Column
    private String name;
    @Column
    private int rowCount;
    @Column
    private int colCount;
    @Column
    private boolean deleted;
    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime updatedAt;

    @Builder
    public Auditorium(String name, int rowCount, int colCount, boolean deleted, LocalDateTime createdAt, LocalDateTime updatedAt){
        this.name = name;
        this.rowCount = rowCount;
        this.colCount = colCount;
        this.deleted = deleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
