package com.capgemini.wsb.rest;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing patients.
 */
@RestController
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @GetMapping("/patient/{id}")
    public PatientTO findById(@PathVariable final Long id) {
        final PatientTO patient = patientService.findById(id);
        if (patient == null) {
            throw new EntityNotFoundException(id);
        }
        cleanPatientTO(patient);
        return patient;
    }
    private void cleanPatientTO(PatientTO patient) {
        patient.getVisits().forEach(visit -> {
            if (visit.getDoctor() != null) {
                visit.getDoctor().setVisits(null);
                visit.getDoctor().setAddress(null);
            }
            visit.setPatient(null);
        });
    }
}
