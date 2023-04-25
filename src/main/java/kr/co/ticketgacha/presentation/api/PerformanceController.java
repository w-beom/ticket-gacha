package kr.co.ticketgacha.presentation.api;

import kr.co.ticketgacha.application.PerformanceService;
import kr.co.ticketgacha.presentation.dto.CreatePerformanceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/performance")
public class PerformanceController {

    private final PerformanceService performanceService;

    @PostMapping
    public ResponseEntity<Void> createPerformance(@RequestBody CreatePerformanceRequest request){
        performanceService.createPerformance(request);
        return ResponseEntity.ok().build();
    }

}
