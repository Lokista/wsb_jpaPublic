package com.test.capgemini.wsb.service;

import com.capgemini.wsb.WsbJpaApplication;
import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.mapper.AddressMapper;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.service.AddressService;
import com.capgemini.wsb.service.DoctorService;
import com.capgemini.wsb.service.PatientService;
import com.capgemini.wsb.service.VisitService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.Address;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WsbJpaApplication.class)
public class AddressServiceTest {
    @Autowired
    private AddressService addressService;

    @Test
    @Transactional
    public void addressByIdTrue() {
        AddressTO address = addressService.findById(1L);
        AddressEntity addressEntity = AddressMapper.mapToEntity(address);

        assertThat(addressEntity).isNotNull();
        assertThat(addressEntity.getId()).isEqualTo(1L);
    }
}
