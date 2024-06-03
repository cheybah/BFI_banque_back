package com.bfi.backend.client.entites;

import com.bfi.backend.admin.entities.Agency;

import com.bfi.backend.client.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.jdbc.core.SqlReturnType;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContact;

    @Column(name = "full_name", nullable = false)
    @Size(max = 100)
    private String fullName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "photo")
    private String imageContact;

    @Column
    private String categorie;
    
    @Column
    @Size(max = 100)
    private String address;

    @ManyToMany(mappedBy = "contacts")
    @JsonIgnore
    private List<Client> clients;
}
