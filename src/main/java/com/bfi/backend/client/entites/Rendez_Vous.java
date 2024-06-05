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
    private String temps;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "raison", nullable = false)
    private String raison;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;

}
