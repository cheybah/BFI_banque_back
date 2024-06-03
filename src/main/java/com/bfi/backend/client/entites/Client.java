package com.bfi.backend.client.entites;

import com.bfi.backend.admin.entities.Agency;

import com.bfi.backend.client.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "table_clients")
public class Client extends User {

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "photo")
    private String photo;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false, unique = true)
    @Size(max = 100)
    private String login;

    @Column(nullable = false)
    @Size(max = 100)
    private String password;

    @Column(name = "status", nullable = false)
    private boolean status;


    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Specify fetch type
    private Address address;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;


    @OneToMany(mappedBy = "client")
    private List<BankAccount> bankAccountList;

    @ManyToMany
    @JoinTable(
            name = "avoir",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id")
    )
    private List<Contact> contacts;
}
