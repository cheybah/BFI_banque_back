package com.bfi.backend.client.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "personne_morale")
public class PersonneMorale extends User {

    private String raisonSocial;
    private String formeJuridique;
    private String abreviation;
    private String categorie;
    private LocalDate dateCreation;
    private String codeRCCM;
    private String codeNIF;
    private String secteurActivite;

}