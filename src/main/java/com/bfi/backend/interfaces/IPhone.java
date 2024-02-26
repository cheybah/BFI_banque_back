package com.bfi.backend.interfaces;

import com.bfi.backend.entites.Phone;

import java.util.List;

public interface IPhone {
    List<Phone> getAllPhones();
    Phone savePhone(Phone phone);
    Phone updatePhone(Long id, Phone phone);
    void deletePhone(Long id);

}

