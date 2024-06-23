package com.bfi.backend.client.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Operation_Bancaire")
public class OperationBancaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private Date date = new Date(); // Initialisation automatique de la date


    @Column(name = "montant", nullable = false) // Changement ici pour utiliser "montant" au lieu de "mantant"
    private Double montant; // Propriété montant dans OperationBancaire

    @Column(name = "motif")
    private Long motif;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "bankaccount_id")
    private BankAccount bankaccount;
}
