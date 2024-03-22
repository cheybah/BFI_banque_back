package com.bfi.backend.admin.entities;

import com.bfi.backend.client.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "agency")
public class Agency {

    @Id //primary key for user
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgency;

    @Column(name = "name", nullable = false)
    @Size(max = 100)
    private String name;


    @Column(name = "ville", nullable = false)
    @Size(max = 100)
    private String ville;

    @Column(name = "tel")
    private String tel;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "address", nullable = false)
    private String address;
}