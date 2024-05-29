package com.bfi.backend.client.dtos;

import com.bfi.backend.client.enums.Gender;

import java.time.LocalDate;
import java.util.List;

public record SignUpPersonnePhysiqueDto (Gender gender, String firstName, String lastName, String photo, String email, String phoneNumber, LocalDate dateOfBirth, String login, char[] password, AddressDto address, AdditionalInfoDto additionalInfo, Long agencyId, List<BankAccountDto> bankAccounts) { }

