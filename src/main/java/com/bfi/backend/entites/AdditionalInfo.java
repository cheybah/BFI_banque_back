package com.bfi.backend.entites;

import com.bfi.backend.enums.TypeIndividual;
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
    @Column(name = "type_individual")
    private TypeIndividual typeIndividual;

    @Column(name = "profession")
    private String profession;

    @Column(name = "piece_type")
    private String pieceType;

    @Column(name = "piece_number")
    private String pieceNumber;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "piece_photo")
    private String piecePhoto;

    @Column(name = "referral_code")
    private String referralCode;

}

