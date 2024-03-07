package com.bfi.backend.client.services;

import com.bfi.backend.client.entites.Address;
import com.bfi.backend.client.interfaces.IAddress;
import com.bfi.backend.client.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddress {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public void saveAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public void updateAddress(Long id, Address address) {
        Address existingAddress = addressRepository.findById(id).orElse(null);

        if (existingAddress != null) {
            existingAddress.setCountry(address.getCountry());
            existingAddress.setCity(address.getCity());
            existingAddress.setNeighbourhood(address.getNeighbourhood());
            existingAddress.setZipCode(address.getZipCode());

            addressRepository.save(existingAddress);
        } else {
            throw new IllegalArgumentException("Address avec ID " + id + " n'existe pas.");
        }
    }

}
