package com.bfi.backend.client.dtos;

import com.bfi.backend.client.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@SuperBuilder
public class PersonneMoraleDto extends ClientDto {
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String photo;
    private String email;
    private String phoneNumber;
    private String raisonSocial;
    private String formeJuridique;
    private String abreviation;
    private String categorie;
    private LocalDate dateCreation;
    private String codeRCCM;
    private String codeNIF;
    private String secteurActivite;
}