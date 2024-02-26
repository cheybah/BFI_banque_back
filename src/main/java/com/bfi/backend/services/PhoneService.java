package com.bfi.backend.services;

import com.bfi.backend.entites.Phone;
import com.bfi.backend.interfaces.IPhone;
import com.bfi.backend.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService implements IPhone {
    private final PhoneRepository phoneRepository;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    // Create a new phone number
    public Phone savePhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    // Retrieve all phone numbers
    public List<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }


    // Update a phone number
    public Phone updatePhone(Long id, Phone newPhoneData) {
        Optional<Phone> optionalPhone = phoneRepository.findById(id);
        if (optionalPhone.isPresent()) {
            Phone existingPhone = optionalPhone.get();
            existingPhone.setNumber(newPhoneData.getNumber());
            existingPhone.setInternationalNumber(newPhoneData.getInternationalNumber());
            existingPhone.setNationalNumber(newPhoneData.getNationalNumber());
            existingPhone.setE164Number(newPhoneData.getE164Number());
            existingPhone.setCountryCode(newPhoneData.getCountryCode());
            return phoneRepository.save(existingPhone);
        } else {
            throw new IllegalArgumentException("Numéro de tél avec cet id " + id + " n'existe pas");
        }
    }

    // Delete a phone number by its ID
    public void deletePhone(Long id) {
        phoneRepository.deleteById(id);
    }
}


