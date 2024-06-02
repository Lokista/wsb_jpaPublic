package com.test.capgemini.wsb.service;

import com.capgemini.wsb.WsbJpaApplication;
import com.capgemini.wsb.service.DoctorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WsbJpaApplication.class)
public class DoctorServiceTest {
    @Autowired
    private DoctorService doctorService;

    @Test
    @Transactional
    public void doctorByIdFind() {
        doctorService.findById(1L);
        assertThat(doctorService.findById(1L)).isNotNull();
        assertThat(doctorService.findById(2L)).isNotNull();
        assertThat(doctorService.findById(3L)).isNotNull();
        assertThat(doctorService.findById(4L)).isNotNull();
        assertThat(doctorService.findById(15L)).isNull();
    }
}