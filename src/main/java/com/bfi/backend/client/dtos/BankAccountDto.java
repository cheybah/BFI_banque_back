package com.bfi.backend.client.dtos;

import com.bfi.backend.client.entites.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountDto {
    private String rib;
    private String code;
    private Long ClientId;
}

