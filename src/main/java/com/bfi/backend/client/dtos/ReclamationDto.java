package com.bfi.backend.client.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ReclamationDto {

    private Long clientId;
    private String reference;
    private String sujet;
    private String contenu;
    private String date;
    private String reponse;
    private String status;

}
