package com.bfi.backend.client.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "vers_mon_contact")
public class VersMonContact extends Virement {

}
