package com.bfi.backend.client.dtos;

import com.bfi.backend.client.entites.PersonnePhysique;
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

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class AdditionalInfoPhysicalDto extends AdditionalInfoDto {
    private String profession;
    private TypeIndividual typeIndividual;

    private PieceType pieceType;
    private String pieceNumber;
    private LocalDate expirationDate;
    private String piecePhoto;
    private String referralCode;

}
