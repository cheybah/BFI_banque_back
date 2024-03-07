package com.bfi.backend.client.controllers;

import com.bfi.backend.client.entites.AdditionalInfo;
import com.bfi.backend.client.services.AdditionalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/dash/autres-informations", produces = "application/json")
public class AdditionalInfoController {

    private final AdditionalInfoService additionalInfoService;

    @Autowired
    public AdditionalInfoController(AdditionalInfoService additionalInfoService) {
        this.additionalInfoService = additionalInfoService;
    }

    @PostMapping
    public ResponseEntity<AdditionalInfo> saveAdditionalInfo(@RequestBody AdditionalInfo additionalInfo) {
        AdditionalInfo savedAdditionalInfo = additionalInfoService.saveAdditionalInfo(additionalInfo);
        return new ResponseEntity<>(savedAdditionalInfo, HttpStatus.CREATED);
    }
}
