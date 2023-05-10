package kr.co.ticketgacha.presentation.dto.response;


import lombok.Builder;

import java.time.LocalDateTime;

public class PerformanceResponse {
    private Long performanceId;
    private String performanceName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean deleted;

    @Builder
    public PerformanceResponse(Long performanceId, String performanceName, LocalDateTime startDate, LocalDateTime endDate, boolean deleted) {
        this.performanceId = performanceId;
        this.performanceName = performanceName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deleted = deleted;
    }
}
