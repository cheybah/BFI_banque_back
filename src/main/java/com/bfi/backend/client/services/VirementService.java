package com.bfi.backend.client.services;

import com.bfi.backend.client.entites.BankAccount;
import com.bfi.backend.client.entites.Virement;
import com.bfi.backend.client.repositories.BankAccountRepository;
import com.bfi.backend.client.repositories.VirementRepository;
import com.bfi.backend.common.exceptions.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

@Service
public class VirementService {

    private static final Logger logger = LoggerFactory.getLogger(VirementService.class);

    @Autowired
    private VirementRepository virementRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;



    public List<Virement> getVirementsByBankAccountRib(String rib) {
        return virementRepository.findByCompteADebiteOrCompteACrediter(rib, rib);
    }
}
