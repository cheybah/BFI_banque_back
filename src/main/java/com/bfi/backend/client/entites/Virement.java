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
@Table(name = "virement")
public class Virement extends OperationBancaire {
    private String  compte_a_debite;
    private String compte_a_crediter;

}
