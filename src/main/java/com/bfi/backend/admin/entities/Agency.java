package com.bfi.backend.admin.entities;

import com.bfi.backend.client.entites.Client;
import com.bfi.backend.client.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "agency")
public class Agency {

    @Id //primary key for Client
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgency;

    @Column(name = "name", nullable = false)
    @Size(max = 100)
    private String name;


    @Column(name = "ville", nullable = false)
    @Size(max = 100)
    private String ville;

    @Column(name = "tel")
    private String tel;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "address", nullable = false)
    private String address;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "agency")
    private List<Client> ClientList;
}