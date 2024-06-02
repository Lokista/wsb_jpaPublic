package com.test.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.WsbJpaApplication;
import com.capgemini.wsb.persistence.dao.AddressDao;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WsbJpaApplication.class)
public class AddressDaoTest {

    @Autowired
    private AddressDao addressDao;

    @Transactional
    @Test
    public void findAdressByTrue() {
        AddressEntity addressEntity = addressDao.findOne(1L);
        assertThat(addressEntity).isNotNull();
        assertThat(addressEntity.getPostalCode()).isEqualTo("11111");
    }

    @Test
    public void saveAdressByTrue() {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLine1("Ul. bytom");
        addressEntity.setAddressLine2("room 10");
        addressEntity.setCity("Poznan");
        addressEntity.setPostalCode("55555");
        long entitiesNumBefore = addressDao.count();
        final AddressEntity saved = addressDao.save(addressEntity);

        // then
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
        assertThat(addressDao.count()).isEqualTo(entitiesNumBefore + 1);
    }

    @Transactional
    @Test
    public void saveRemoveAddressTrue() {
        // given
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLine1("Ul. Klonowa");
        addressEntity.setAddressLine2("Apt 5");
        addressEntity.setCity("Metropolis");
        addressEntity.setPostalCode("22222");

        // when
        final AddressEntity saved = addressDao.save(addressEntity);
        assertThat(saved.getId()).isNotNull();
        final AddressEntity newSaved = addressDao.findOne(saved.getId());
        assertThat(newSaved).isNotNull();

        addressDao.delete(saved.getId());

        // then
        final AddressEntity removed = addressDao.findOne(saved.getId());
        assertThat(removed).isNull();
    }
}
