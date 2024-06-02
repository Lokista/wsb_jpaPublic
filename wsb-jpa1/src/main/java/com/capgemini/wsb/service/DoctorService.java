package com.capgemini.wsb.service;
import com.capgemini.wsb.dto.DoctorTO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public interface DoctorService
{
    DoctorTO findById(final Long id);
}
