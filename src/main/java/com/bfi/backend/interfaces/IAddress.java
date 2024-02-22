package com.bfi.backend.interfaces;

import com.bfi.backend.entites.Address;

import java.util.List;

public interface IAddress {
    List<Address> getAll();
    Object getAddressById(Long id);
    void saveAddress(Address address);
    void updateAddress(Long id, Address address);

}
