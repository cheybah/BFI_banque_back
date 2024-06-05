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
@Table(name = "Notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotification;


    @Column(name = "status")
    private String status;

    @Column(name = "contenu", nullable = false)
    private String contenu;

    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "raison", nullable = false)
    private String Titre;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;

}
