package com.bfi.backend.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "Counter")
public class Counter
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project", nullable = false)
    @Size(max = 100)
    private int project;

    @Column(name = "loans", nullable = false)
    @Size(max = 100)
    private float loans;

    @Column(name = "interest_rates", nullable = false)
    @Size(max = 100)
    private float interestRates;


    @Column(name = "satisfied_customers", nullable = false)
    @Size(max = 100)
    private float satisfiedCustomers;

}
