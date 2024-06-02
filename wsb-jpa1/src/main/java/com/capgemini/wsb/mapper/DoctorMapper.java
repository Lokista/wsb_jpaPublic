package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.dto.DoctorTO;

public final class DoctorMapper
{
    public static DoctorTO maptToTO(final DoctorEntity doctorEntity)
    {
        if (doctorEntity == null)
        {
            return null;
        }
        DoctorTO doctorTO = new DoctorTO();
        doctorTO.setDoctorNumber(doctorEntity.getDoctorNumber());
        doctorTO.setAddress(doctorEntity.getAddress());
        doctorTO.setEmail(doctorEntity.getEmail());
        doctorTO.setId(doctorEntity.getId());
        doctorTO.setTelephoneNumber(doctorEntity.getTelephoneNumber());
        doctorTO.setFirstName(doctorEntity.getFirstName());
        doctorTO.setVisits(doctorEntity.getVisits());
        doctorTO.setLastName(doctorEntity.getLastName());
        doctorTO.setSpecialization(doctorEntity.getSpecialization());
        return doctorTO;
    }

    public static DoctorEntity mapToEntity(final DoctorTO doctorTO)
    {
        if (doctorTO == null)
        {
            return null;
        }
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setDoctorNumber(doctorTO.getDoctorNumber());
        doctorEntity.setAddress(doctorTO.getAddress());
        doctorEntity.setSpecialization(doctorTO.getSpecialization());
        doctorEntity.setEmail(doctorTO.getEmail());
        doctorEntity.setId(doctorTO.getId());
        doctorEntity.setTelephoneNumber(doctorTO.getTelephoneNumber());
        doctorEntity.setFirstName(doctorTO.getFirstName());
        doctorEntity.setVisits(doctorTO.getVisits());
        doctorEntity.setLastName(doctorTO.getLastName());
        return doctorEntity;
    }
}
