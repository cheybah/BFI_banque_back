package com.bfi.backend.admin.entities;


import com.bfi.backend.admin.enums.AdminRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "blog") // Table name for admin panel Clients
public class Blogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(max = 100)
    private String blog_title;

    @Column(nullable = false)
    @Size(max = 100)
    private String blog_description;

    @Column(nullable = false)
    @Size(max = 255)
    private String blog_photo;

}
