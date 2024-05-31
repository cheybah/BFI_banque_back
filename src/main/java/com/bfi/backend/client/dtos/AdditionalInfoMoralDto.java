package com.bfi.backend.client.dtos;

import com.bfi.backend.client.enums.PieceType;
import com.bfi.backend.client.enums.TypeIndividual;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class AdditionalInfoMoralDto extends AdditionalInfoDto {

    private String companySize;
    private String fieldActivity;
    private String natureSector;

    private TypeIndividual typeIndividual;
    private String profession;
    private PieceType pieceType;
    private String pieceNumber;
    private LocalDate expirationDate;
    private String piecePhoto;
    private String referralCode;
}
