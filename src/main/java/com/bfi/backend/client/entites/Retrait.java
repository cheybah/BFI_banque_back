package com.bfi.backend.client.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "Retrait")
public class Retrait extends OperationBancaire {
    private String retrait_option;
    private String retrait_compte_source;
}
