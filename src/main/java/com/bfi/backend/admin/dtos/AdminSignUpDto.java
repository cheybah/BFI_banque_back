package com.bfi.backend.admin.dtos;


import com.bfi.backend.admin.enums.AdminRole;

public record AdminSignUpDto (String firstName, String lastName, String photo, String email, String login, char[] password, AdminRole role) { }

