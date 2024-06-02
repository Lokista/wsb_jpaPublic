package com.test.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.mapper.DoctorMapper;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.enums.Specialization;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = DoctorMapperTest.class)
public class DoctorMapperTest {

    @Test
    public void doctorTo()
    {
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(2L);
        doctorEntity.setFirstName("Anna");
        doctorEntity.setLastName("Nowak");
        doctorEntity.setTelephoneNumber("333333333");
        doctorEntity.setEmail("anianowak@GMEIL.com");
        doctorEntity.setDoctorNumber("D5555");
        doctorEntity.setSpecialization(Specialization.DENTIST);

        DoctorTO doctorTO = DoctorMapper.maptToTO(doctorEntity);
        assertEquals(2L, doctorTO.getId());
        assertEquals("Anna", doctorTO.getFirstName());
        assertEquals("Nowak", doctorTO.getLastName());
        assertEquals("333333333", doctorTO.getTelephoneNumber());
        assertEquals("D5555", doctorTO.getDoctorNumber());
        assertEquals(Specialization.DENTIST, doctorTO.getSpecialization());
    }

    @Test
    public void TOtoDoctor()
    {
        DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(2L);
        doctorTO.setFirstName("Anna");
        doctorTO.setLastName("Nowak");
        doctorTO.setTelephoneNumber("333333333");
        doctorTO.setDoctorNumber("D5555");
        doctorTO.setEmail("annanowak@gmeile.com");
        doctorTO.setSpecialization(Specialization.DENTIST);
        assertEquals(2L, doctorTO.getId());
        assertEquals("Anna", doctorTO.getFirstName());
        assertEquals("Nowak", doctorTO.getLastName());
        assertEquals("333333333", doctorTO.getTelephoneNumber());
        assertEquals("D5555", doctorTO.getDoctorNumber());
        assertEquals(Specialization.DENTIST, doctorTO.getSpecialization());
    }
}
