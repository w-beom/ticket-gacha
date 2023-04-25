package kr.co.ticketgacha.application;

import kr.co.ticketgacha.domain.auditorium.Auditorium;
import kr.co.ticketgacha.domain.auditorium.AuditoriumRepository;
import kr.co.ticketgacha.domain.performacne.Performance;
import kr.co.ticketgacha.domain.performacne.PerformanceRepository;
import kr.co.ticketgacha.presentation.dto.CreatePerformanceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PerformanceService {
    private final PerformanceRepository performanceRepository;
    private final AuditoriumRepository auditoriumRepository;

    @Transactional
    public void createPerformance(CreatePerformanceRequest request) {
        Auditorium auditorium = auditoriumRepository.findById(request.getAuditoriumId())
                .orElseThrow();

        Performance performance = Performance.builder()
                .auditorium(auditorium)
                .name(request.getName())
                .start(request.getStart())
                .end(request.getEnd())
                .deleted(request.isDeleted())
                .build();

        performanceRepository.save(performance);
    }
}
