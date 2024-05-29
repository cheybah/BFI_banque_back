package com.bfi.backend.client.dtos;

import com.bfi.backend.client.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ClientDto {

    private Long id;
    private Gender gender;
    private String firstName;
    private String lastName;
    private String photo;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String login;
    private String token;
    private AddressDto address;
    private AdditionalInfoDto additionalInfo ;
    private Long agencyId;
    private List<BankAccountDto> bankAccounts;

}
