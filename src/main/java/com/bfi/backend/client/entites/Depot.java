package com.bfi.backend.client.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@Table(name = "Depot")
public class Depot extends OperationBancaire {

    private String depot_option; // Propriété spécifique à Depot
    private String depot_compte_source; // Propriété spécifique à Depot
}
