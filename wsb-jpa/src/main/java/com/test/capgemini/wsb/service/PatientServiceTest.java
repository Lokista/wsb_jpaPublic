package com.test.capgemini.wsb.service;

import com.capgemini.wsb.WsbJpaApplication;
import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.DoctorMapper;
import com.capgemini.wsb.mapper.VisitMapper;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.DoctorService;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.PatientService;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.dto.PatientTO;

import com.capgemini.wsb.service.VisitService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WsbJpaApplication.class)
public class PatientServiceTest
{
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private VisitService visitService;

    @DirtiesContext
    @Test
    public void findPatientById()
    {
        PatientTO patientTO = patientService.findById(1L);
        PatientEntity patientEntity = PatientMapper.mapToEntity(patientTO);
        assertThat(patientEntity).isNotNull();
        assertThat(patientEntity.getId()).isEqualTo(1);
        assertThat(patientEntity.getLastName()).isEqualTo("Nowak");
    }

    @DirtiesContext
    @Test
    public void removeVisit()
    {
        patientService.removePatientEntity(1L);
        PatientTO patientTO = patientService.findById(1L);
        PatientEntity patientEntity = PatientMapper.mapToEntity(patientTO);
        assertThat(patientEntity).isNull();
        DoctorTO doctorTO = doctorService.findById(1L);
        DoctorEntity doctorEntity = DoctorMapper.mapToEntity(doctorTO);
        assertThat(doctorEntity).isNotNull();
        VisitTO visitTO = visitService.findById(1L);
        VisitEntity visitEntity = VisitMapper.TOtoMap(visitTO);
        assertThat(visitEntity).isNull();
    }

    @Test
    public void givePatientVisitsWithId()
    {
        Collection<VisitEntity> visits = patientService.findVisitsById(1L);
        assertThat(visits).isNotNull();
        assertThat(visits).isNotEmpty();
    }
}
