package com.bfi.backend.client.services;

import com.bfi.backend.client.entites.AdditionalInfo;
import com.bfi.backend.client.interfaces.IAdditionalInfo;
import com.bfi.backend.client.repositories.AdditionalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdditionalInfoService implements IAdditionalInfo {

    private final AdditionalInfoRepository additionalInfoRepository;

    @Autowired
    public AdditionalInfoService(AdditionalInfoRepository additionalInfoRepository) {
        this.additionalInfoRepository = additionalInfoRepository;
    }

    @Override
    public AdditionalInfo saveAdditionalInfo(AdditionalInfo additionalInfo) {
        return additionalInfoRepository.save(additionalInfo);
    }
}
