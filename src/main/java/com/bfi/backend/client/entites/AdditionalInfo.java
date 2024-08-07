package com.bfi.backend.client.entites;

import com.bfi.backend.client.enums.PieceType;
import com.bfi.backend.client.enums.TypeIndividual;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)

@Table(name = "additional_info")
public class AdditionalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PieceType pieceType;

    @Column(nullable = false)
    private String piecePhoto;
    @Column(nullable = false)
    private String referralCode;

    @Column(nullable = false)
    private String pieceNumber;

    @Column(nullable = false)
    private LocalDate expirationDate;

}

