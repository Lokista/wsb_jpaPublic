package com.capgemini.wsb.mapper;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.service.PatientService;

public final class PatientMapper
{
    public static PatientTO mapToTO(final PatientEntity patientEntity)
    {
        if (patientEntity == null)
        {
            return null;
        }
        PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setAddress(patientEntity.getAddress());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setVisits(patientEntity.getVisits());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setPatientHistory(patientEntity.getPatientHistory());
        return patientTO;
    }

    public static PatientEntity mapToEntity(final PatientTO patientTO)
    {
        if (patientTO == null)
        {
            return null;
        }
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientTO.getId());
        patientEntity.setAddress(patientTO.getAddress());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setVisits(patientTO.getVisits());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setPatientHistory(patientTO.getPatientHistory());
        return patientEntity;
    }
}
