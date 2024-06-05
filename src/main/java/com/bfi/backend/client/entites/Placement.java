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
@Table(name = "placement")
public class Placement extends OperationBancaire{



    private String moment_de_paiement;
    private String duree;
    private String taux;
    private String regime_interet;
    private String renouvellement_automatique;
    private String Question;
}
