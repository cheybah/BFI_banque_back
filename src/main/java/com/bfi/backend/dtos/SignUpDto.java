package com.bfi.backend.dtos;

import com.bfi.backend.enums.Gender;

import java.time.LocalDate;

public record SignUpDto (Gender gender, String firstName, String lastName, String photo, String email, String phoneNumber, LocalDate dateOfBirth, String login, char[] password) { }