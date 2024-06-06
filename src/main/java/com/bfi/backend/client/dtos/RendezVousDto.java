package com.bfi.backend.client.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class RendezVousDto {

    private Long id;
    private Long clientId;
    private String agence;
    private String raison;
    private String date;
    private String heure;
    private String status;

}
