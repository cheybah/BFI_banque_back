package com.bfi.backend.dtos;

import com.bfi.backend.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private Gender gender;
    private String firstName;
    private String lastName;
    private String photo;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String login;
    private String token;



}
