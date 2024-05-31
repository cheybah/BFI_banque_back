package com.bfi.backend.client.entites;

import com.bfi.backend.admin.entities.Agency;
import com.bfi.backend.client.enums.Gender;
import jakarta.persistence.*;
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

    @OneToOne(mappedBy = "PersonneMorale", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AdditionalInfoCorporation additionalInfo;

}