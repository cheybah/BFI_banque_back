package com.bfi.backend.client.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VirementDto {
    private Long clientId;
    private String compteADebiter;
    private String compteACrediter;
    private Double montant;
    private Long motif;

}
