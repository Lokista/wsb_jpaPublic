package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long>
{
    public List<PatientEntity> patientLastName(String lastName);
    public List<PatientEntity> patientVisitsExtend(Integer X);
    public List<PatientEntity> patientWithCondition(String history);
}
