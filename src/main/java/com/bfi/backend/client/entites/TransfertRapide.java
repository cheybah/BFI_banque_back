package com.bfi.backend.client.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "Transfert_Rapide")
public class TransfertRapide extends OperationBancaire {

    private String pieceIdentite;
    private String telephoneBeneficiaire;
    private String prenomBeneficiaire;
    private String nomBeneficiaire;
    private String reponse;
    private String question;
    private String frais;
    private String compteAdebiter;
    private String pays;
    private String canalTransfert;
}
