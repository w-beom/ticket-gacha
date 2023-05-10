package kr.co.ticketgacha.presentation.dto.request;

import jakarta.annotation.Nonnull;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreatePerformanceRequest {
    @Nonnull
    private Long auditoriumId;
    @Nonnull
    private String name;
    @Nonnull
    private LocalDateTime start;
    @Nonnull
    private LocalDateTime end;
    @Nonnull
    private boolean deleted;
}
