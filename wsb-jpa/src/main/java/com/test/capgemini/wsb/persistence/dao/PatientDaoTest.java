package com.test.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.WsbJpaApplication;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WsbJpaApplication.class)
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void patientFindLastNameTrue() {
        List<PatientEntity> foundPatients = patientDao.patientLastName("Roberts");
        assertThat(foundPatients).isNotNull();
        assertThat(foundPatients.size()).isEqualTo(1);
    }

    @Transactional
    @Test
    public void patientMoreVisitTrue() {
        List<PatientEntity> foundPatients = patientDao.patientVisitsExtend(3);
        assertThat(foundPatients).isNotNull();
        assertThat(foundPatients).isEmpty();
    }

    @Transactional
    @Test
    public void patientFindByHistoryFalseThenTrue() {
        List<PatientEntity> foundPatientsWithCukrzyca = patientDao.patientWithCondition("Pierogi");
        assertThat(foundPatientsWithCukrzyca).isNotNull();
        assertThat(foundPatientsWithCukrzyca).isEmpty();

        List<PatientEntity> foundPatientsWithAstma = patientDao.patientWithCondition("astma");
        assertThat(foundPatientsWithAstma).isNotNull();
        assertThat(foundPatientsWithAstma).isNotEmpty();
    }

    @Transactional
    @Test
    public void shouldSaveAndRetrievePatient() {
        // Given
        PatientEntity newPatient = new PatientEntity();
        newPatient.setFirstName("Adam");
        newPatient.setLastName("Tracz");
        newPatient.setTelephoneNumber("333333333");
        newPatient.setEmail("mapentracz@gmeil.com");
        newPatient.setPatientNumber("P2005");
        newPatient.setDateOfBirth(LocalDate.of(1985, 10, 15));
        newPatient.setPatientHistory("Homo");

        PatientEntity savedPatient = patientDao.save(newPatient);

        assertThat(savedPatient).isNotNull();
        assertThat(savedPatient.getId()).isNotNull();
        assertThat(savedPatient.getFirstName()).isEqualTo("Adam");
        assertThat(savedPatient.getLastName()).isEqualTo("Tracz");
    }

    @Transactional
    @Test
    public void shouldDeletePatient() {
        // Given
        PatientEntity existingPatient = patientDao.findOne(2L);
        assertThat(existingPatient).isNotNull();

        patientDao.delete(existingPatient);

        PatientEntity deletedPatient = patientDao.findOne(2L);
        assertThat(deletedPatient).isNull();
    }
}
