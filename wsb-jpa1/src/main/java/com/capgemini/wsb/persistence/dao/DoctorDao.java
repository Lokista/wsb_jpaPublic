package com.capgemini.wsb.persistence.dao;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;

public interface DoctorDao extends Dao<DoctorEntity, Long>
{
}