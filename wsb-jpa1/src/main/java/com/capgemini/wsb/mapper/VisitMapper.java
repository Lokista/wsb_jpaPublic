package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.Collection;

public class VisitMapper
{
    public static VisitTO mapToTO(final VisitEntity visitEntity)
    {
        if (visitEntity == null)
        {
            return null;
        }
        VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setDoctor(visitEntity.getDoctor());
        visitTO.setTime(visitEntity.getTime());
        visitTO.setTratments(visitEntity.getTreatments());
        visitTO.setPatientEntity(visitEntity.getPatient());

        return visitTO;
    }

    public static VisitEntity TOtoMap(final VisitTO visitTO)
    {
        if (visitTO == null)
        {
            return null;
        }
        VisitEntity  visitEntity = new VisitEntity();
        visitEntity.setId(visitTO.getId());
        visitEntity.setDescription(visitTO.getDescription());
        visitEntity.setDoctor(visitTO.getDoctor());
        visitEntity.setTime(visitTO.getTime());
        visitEntity.setTreatments(visitTO.getTratments());
        visitEntity.setPatient(visitTO.getPatientEntity());

        return visitEntity;
    }
}
