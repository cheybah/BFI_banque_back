package com.bfi.backend.client.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Rendez_Vous")
public class Rendez_Vous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "temps")
    private String agence;
    @Column(name = "raison", nullable = false)
    private String raison;
    @Column(name = "date", nullable = false)
    private String date;
    @Column(name = "heure", nullable = false)
    private String heure;
    @Column(name = "status", nullable = false)
    private String status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;

}
