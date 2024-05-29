package com.bfi.backend.client.entites;

import com.bfi.backend.client.enums.PieceType;
import com.bfi.backend.client.enums.TypeIndividual;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "additional_info")
public class AdditionalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeIndividual typeIndividual;

    @Column(nullable = false)
    private String profession;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PieceType pieceType;

    @Column(nullable = false)
    private String pieceNumber;

    @Column(nullable = false)
    private LocalDate expirationDate;

    @Column(nullable = false)
    private String piecePhoto;

    @Column(nullable = false)
    private String referralCode;

    // Define the relationship with Client entity
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Client_id")
    private Client Client;

}

