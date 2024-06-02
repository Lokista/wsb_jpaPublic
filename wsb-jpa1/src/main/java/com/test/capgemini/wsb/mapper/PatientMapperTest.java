package com.test.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = PatientMapperTest.class)
public class PatientMapperTest {
    @Test
    public void patientEntity()
    {
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(2L);
        patientEntity.setFirstName("Marek");
        patientEntity.setLastName("Kowalski");
        patientEntity.setTelephoneNumber("5555555");
        patientEntity.setPatientNumber("P999");
        patientEntity.setDateOfBirth(LocalDate.of(1994, 6, 15));
        patientEntity.setEmail("marekkowalski@gmeil.com");
        patientEntity.setPatientHistory("Zdrowy");

        PatientTO patientTO = PatientMapper.mapToTO(patientEntity);

        assertNotNull(patientTO);
        assertEquals(2L, patientTO.getId());
        assertEquals("Marek", patientTO.getFirstName());
        assertEquals("Kowalski", patientTO.getLastName());
        assertEquals("5555555", patientTO.getTelephoneNumber());
        assertEquals("P999", patientTO.getPatientNumber());
        assertEquals("Zdrowy", patientTO.getPatientHistory());
        assertEquals("marekkowalski@gmeil.com", patientTO.getEmail());
        assertEquals(LocalDate.of(1994, 6, 15), patientTO.getDateOfBirth());
    }

    @Test
    public void patientTo()
    {
        PatientTO patientTO = new PatientTO();
        patientTO.setId(2L);
        patientTO.setFirstName("Marek");
        patientTO.setLastName("Kowalski");
        patientTO.setTelephoneNumber("5555555");
        patientTO.setPatientNumber("P999");
        patientTO.setDateOfBirth(LocalDate.of(1994, 6, 15));
        patientTO.setEmail("marekkowalski@gmeil.com");
        patientTO.setPatientHistory("Zdrowy");

        PatientEntity patientEntity = PatientMapper.mapToEntity(patientTO);

        assertNotNull(patientEntity);
        assertEquals(2L, patientEntity.getId());
        assertEquals("Marek", patientEntity.getFirstName());
        assertEquals("Kowalski", patientEntity.getLastName());
        assertEquals("5555555", patientEntity.getTelephoneNumber());
        assertEquals("P999", patientEntity.getPatientNumber());
        assertEquals("Zdrowy", patientEntity.getPatientHistory());
        assertEquals("marekkowalski@gmeil.com", patientEntity.getEmail());
        assertEquals(LocalDate.of(1994, 6, 15), patientEntity.getDateOfBirth());
    }
}
