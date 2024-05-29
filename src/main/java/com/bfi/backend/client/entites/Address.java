package com.bfi.backend.client.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String neighbourhood;

    @Column(nullable = false)
    private String zipCode;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY) // Specify fetch type
    @JoinColumn(name = "Client_id")
    private Client Client; // Foreign key referencing the Client table
}
