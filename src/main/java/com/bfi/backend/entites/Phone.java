package com.bfi.backend.entites;

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
@Table(name = "user_phone")
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
    @JoinColumn(name = "user_id") // Assuming this is the column name in the user_phone table that references the User
    private User user; // Add this field

    // Add setter method for user
    //public void setUser(User user) {
      //  this.user = user;
   // }

}

