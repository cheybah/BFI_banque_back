package com.bfi.backend.client.entites;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "personne_physique")
public class PersonnePhysique extends Client {


    @OneToOne(mappedBy = "PersonnePhysique", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AdditionalInfoPhysical additionalInfo;
}