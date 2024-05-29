package com.bfi.backend.client.entites;

import com.bfi.backend.admin.entities.Agency;
import com.bfi.backend.client.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor // Assurez-vous que cette annotation est présente

@SuperBuilder
@Entity
@Table(name = "personne_morale")
public class PersonneMorale extends Client {

    private String raisonSocial;
    private String formeJuridique;
    private String abreviation;
    private String categorie;
    private LocalDate dateCreation;
    private String codeRCCM;
    private String codeNIF;
    private String secteurActivite;

    public PersonneMorale(Long id, Gender gender, @Size(max = 100) String firstName, @Size(max = 100) String lastName, String photo, String email, String phoneNumber, LocalDate dateOfBirth, @Size(max = 100) String login, @Size(max = 100) String password, boolean status, Address address, AdditionalInfo additionalInfo, Agency agency, List<BankAccount> bankAccountList, String raisonSocial, String formeJuridique, String abreviation, String categorie, LocalDate dateCreation, String codeRCCM, String codeNIF, String secteurActivite) {
        super(id, gender, firstName, lastName, photo, email, phoneNumber, dateOfBirth, login, password, status, address, additionalInfo, agency, bankAccountList);
        this.raisonSocial = raisonSocial;
        this.formeJuridique = formeJuridique;
        this.abreviation = abreviation;
        this.categorie = categorie;
        this.dateCreation = dateCreation;
        this.codeRCCM = codeRCCM;
        this.codeNIF = codeNIF;
        this.secteurActivite = secteurActivite;
    }
}