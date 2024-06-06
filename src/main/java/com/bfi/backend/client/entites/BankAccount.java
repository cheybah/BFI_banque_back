package com.bfi.backend.client.entites;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank_account")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "rib", nullable = false, unique = true)
    private String rib;


    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "solde")
    private Double solde;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "bankaccount")
    private List<OperationBancaire> operationbancaireList;
}


