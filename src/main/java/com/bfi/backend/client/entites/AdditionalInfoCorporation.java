package com.bfi.backend.client.entites;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor

@SuperBuilder
@Entity
@Table(name = "additional_info_corporation")
public class AdditionalInfoCorporation extends AdditionalInfo{
    private String companySize;
    private String fieldActivity;
    private String natureSector;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ClientMorale_id")
    private PersonneMorale PersonneMorale;
}
