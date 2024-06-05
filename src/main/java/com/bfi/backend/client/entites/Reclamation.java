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
@Table(name = "Reclamation")
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReclamation;
    @Column(name = "etat")
    private String etat;
    @Column(name = "reponse")
    private String reponse;
    @Column(name = "date")
    private Date date;
    @Column(name = "contenu")
    private String contenu;
    @Column(name = "sujet")
    private String sujet;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;

}
