package com.bfi.backend.client.entites;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


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


    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_type_id", nullable = false)


    private AccountType accountType; */
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Client_id")
    private Client Client;


}


