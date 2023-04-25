package kr.co.ticketgacha.domain;

import kr.co.ticketgacha.domain.auditorium.Auditorium;
import kr.co.ticketgacha.domain.auditorium.AuditoriumRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class AuditoriumTest {

    @Autowired
    AuditoriumRepository auditoriumRepository;

    @BeforeEach
    public void 디비_리셋(){
        auditoriumRepository.deleteAll();
    }

    @Test
    public void 공연장_생성_삭제(){

        // given
        String name = "테스트공연";
        int rowCount = 5;
        int colCount = 10;
        boolean deleted = false;
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime updatedAt = LocalDateTime.now();

        auditoriumRepository.save(Auditorium.builder()
                                            .name(name)
                                            .rowCount(rowCount)
                                            .colCount(colCount)
                                            .deleted(deleted)
                                            .createdAt(createdAt)
                                            .updatedAt(updatedAt)
                                            .build());

        // when
        List<Auditorium> auditoriumList = auditoriumRepository.findAll();

        // then
        Auditorium auditorium = auditoriumList.get(0);
        Assertions.assertEquals(auditorium.getName(), name);
        Assertions.assertEquals(auditorium.getRowCount(), rowCount);
        Assertions.assertEquals(auditorium.getColCount(), colCount);
        //Assertions.assertEquals(auditorium.getUpdatedAt(), updatedAt);
        //Assertions.assertEquals(auditorium.getCreatedAt(), createdAt);

    }
}
