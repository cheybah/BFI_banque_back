package com.bfi.backend.client.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@Table(name = "Depot")
public class Depot extends OperationBancaire {

    private String depot_option; // Propriété spécifique à Depot
    private String depot_compte_source; // Propriété spécifique à Depot
    private Boolean isApproved ; // Nouveau champ pour le statut d'approbation

    // Constructeur spécifique pour les dépôts
    public Depot(Double montant, String depot_compte_source) {
        this.setMontant(montant);
        this.depot_compte_source = depot_compte_source;
    }
}
