package com.test.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.mapper.AddressMapper;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = AddressMapperTest.class)
public class AddressMapperTest {

    @Test
    public void addressEntityTo() {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(1L);
        addressEntity.setAddressLine1("Ul. Zielona");
        addressEntity.setAddressLine2("room 3");
        addressEntity.setCity("Poznań");
        addressEntity.setPostalCode("12345");

        AddressTO addressTO = AddressMapper.mapToTO(addressEntity);
        assertEquals(addressEntity.getAddressLine1(), addressTO.getAddressLine1());
        assertEquals(addressEntity.getAddressLine2(), addressTO.getAddressLine2());
        assertEquals(addressEntity.getCity(), addressTO.getCity());
        assertEquals(addressEntity.getPostalCode(), addressTO.getPostalCode());
        assertEquals(addressEntity.getId(), addressTO.getId());
    }

    @Test
    public void addressEntity()
    {
        AddressTO addressTO = new AddressTO();
        addressTO.setAddressLine1("Ul. Jasna");
        addressTO.setAddressLine2("room 6");
        addressTO.setCity("Warszawa");
        addressTO.setPostalCode("54321");
        AddressEntity addressEntity = AddressMapper.mapToEntity(addressTO);
        assertEquals(addressEntity.getAddressLine1(), addressTO.getAddressLine1());
        assertEquals(addressEntity.getAddressLine2(), addressTO.getAddressLine2());
        assertEquals(addressEntity.getCity(), addressTO.getCity());
        assertEquals(addressEntity.getPostalCode(), addressTO.getPostalCode());
        assertEquals(addressEntity.getId(), addressTO.getId());
    }
}
