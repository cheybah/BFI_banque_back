package com.bfi.backend.client.dtos;

import com.bfi.backend.client.entites.AdditionalInfoPhysical;
import com.bfi.backend.client.enums.Gender;

import java.time.LocalDate;
import java.util.List;

public record SignUpPersonnePhysiqueDto (Gender gender, String firstName, String lastName, String photo, String email, String phoneNumber, LocalDate dateOfBirth, String login, char[] password, AddressDto address, AdditionalInfoPhysical additionalInfo, Long agencyId, List<BankAccountDto> bankAccounts) { }

