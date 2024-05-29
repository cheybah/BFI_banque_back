package com.bfi.backend.client.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Client_phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String number;

    @Column(name = "international_number")
    private String internationalNumber;

    @Column(name = "national_number")
    private String nationalNumber;

    @Column(name = "e164_number")
    private String e164Number;

    @Column(name = "country_code")
    private String countryCode;

    @ManyToOne
    @JoinColumn(name = "Client_id") // Assuming this is the column name in the Client_phone table that references the Client
    private Client Client; // Add this field

    // Add setter method for Client
    //public void setClient(Client Client) {
      //  this.Client = Client;
   // }

}

