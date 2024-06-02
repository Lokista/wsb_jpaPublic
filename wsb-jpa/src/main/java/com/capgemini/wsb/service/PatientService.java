package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.Collection;
import java.util.List;

public interface PatientService {
    PatientTO findById(final Long id);
    void removePatientEntity(long id);
    Collection<VisitEntity> findVisitsById(long id);
}
