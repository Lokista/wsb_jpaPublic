package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {
    @Override
    public List<PatientEntity> patientLastName(String lastName) {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "SELECT p FROM PatientEntity p WHERE p.lastName LIKE :lastName", PatientEntity.class);
        query.setParameter("lastName", "%" + lastName + "%");
        return query.getResultList();
    }

    @Override
    public List<PatientEntity> patientVisitsExtend(Integer X) {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "SELECT DISTINCT p FROM PatientEntity p JOIN p.visits v GROUP BY p HAVING COUNT(v) > :X", PatientEntity.class);
        query.setParameter("X", (long) X);
        return query.getResultList();
    }

    @Override
    public List<PatientEntity> patientWithCondition(String word) {
        TypedQuery<PatientEntity> query = entityManager.createQuery(
                "SELECT p FROM PatientEntity p WHERE p.patientHistory LIKE :word", PatientEntity.class);
        query.setParameter("word", "%" + word + "%");
        return query.getResultList();
    }
}
