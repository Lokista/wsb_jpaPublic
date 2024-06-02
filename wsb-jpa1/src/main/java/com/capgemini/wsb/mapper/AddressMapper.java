package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.persistence.entity.AddressEntity;

public final class AddressMapper {

    // Private constructor to prevent instantiation
    private AddressMapper() {
        throw new UnsupportedOperationException("Utility class");
    }
    public static AddressTO mapToTO(final AddressEntity addressEntity) {
        if (addressEntity == null) {
            return null;
        }
        AddressTO addressTO = new AddressTO();
        addressTO.setId(addressEntity.getId());
        addressTO.setAddressLine1(addressEntity.getAddressLine1());
        addressTO.setAddressLine2(addressEntity.getAddressLine2());
        addressTO.setCity(addressEntity.getCity());
        addressTO.setPostalCode(addressEntity.getPostalCode());
        return addressTO;
    }
    public static AddressEntity mapToEntity(final AddressTO addressTO) {
        if (addressTO == null) {
            return null;
        }
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(addressTO.getId());
        addressEntity.setAddressLine1(addressTO.getAddressLine1());
        addressEntity.setAddressLine2(addressTO.getAddressLine2());
        addressEntity.setCity(addressTO.getCity());
        addressEntity.setPostalCode(addressTO.getPostalCode());
        return addressEntity;
    }
}
