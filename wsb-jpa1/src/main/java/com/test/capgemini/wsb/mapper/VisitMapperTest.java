package com.test.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = VisitMapperTest.class)
public class VisitMapperTest {

    @Test
    public void visitEntity()
    {
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(2L);
        visitEntity.setDescription("Badanie krwi");
        visitEntity.setTime(LocalDateTime.now());

        VisitTO visitTO = VisitMapper.mapToTO(visitEntity);
        assertEquals(visitEntity.getId(), visitTO.getId());
        assertEquals(visitEntity.getDescription(), visitTO.getDescription());
        assertEquals(visitEntity.getTime(), visitTO.getTime());
    }

    @Test
    public void visitTO()
    {
        VisitTO visitTO = new VisitTO();
        visitTO.setId(2L);
        visitTO.setDescription("Badanie krwi");
        visitTO.setTime(LocalDateTime.now());

        VisitEntity visitEntity = VisitMapper.TOtoMap(visitTO);
        assertEquals(visitTO.getId(), visitEntity.getId());
        assertEquals(visitTO.getDescription(), visitEntity.getDescription());
        assertEquals(visitTO.getTime(), visitEntity.getTime());
    }
}
