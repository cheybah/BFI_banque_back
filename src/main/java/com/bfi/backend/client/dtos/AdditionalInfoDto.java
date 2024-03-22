package com.bfi.backend.client.dtos;

import com.bfi.backend.client.enums.PieceType;
import com.bfi.backend.client.enums.TypeIndividual;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdditionalInfoDto {

    private TypeIndividual typeIndividual;
    private String profession;
    private PieceType pieceType;
    private String pieceNumber;
    private LocalDate expirationDate;
    private String piecePhoto;
    private String referralCode;
}
