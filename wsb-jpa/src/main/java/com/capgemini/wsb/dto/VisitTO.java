package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.dao.impl.AbstractDao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
import java.util.Collection;

public class VisitTO
{
    private Long id;
    private String description;
    private LocalDateTime time;
    @JsonIgnoreProperties({"doctor"})
    private DoctorEntity doctor;
    @JsonIgnoreProperties({"patientEntity"})
    private PatientEntity patientEntity;
    private Collection<MedicalTreatmentEntity> tratments;

    public Collection<MedicalTreatmentEntity> getTratments() {
        return tratments;
    }

    public void setTratments(Collection<MedicalTreatmentEntity> tratments) {
        this.tratments = tratments;
    }

    @JsonIgnore
    public PatientEntity getPatientEntity() {
        return patientEntity;
    }

    public void setPatientEntity(PatientEntity patientEntity) {
        this.patientEntity = patientEntity;
    }
    @JsonIgnore
    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
