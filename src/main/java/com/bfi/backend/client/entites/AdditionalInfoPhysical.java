package com.bfi.backend.client.entites;

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
@Entity
@Table(name = "additional_info_physical")
public class AdditionalInfoPhysical extends AdditionalInfo{
    @Column(nullable = false)
    private String profession;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeIndividual typeIndividual;
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ClientPhysique_id")
    private PersonnePhysique PersonnePhysique;

}
