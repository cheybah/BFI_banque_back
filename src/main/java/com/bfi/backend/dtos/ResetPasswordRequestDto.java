package com.bfi.backend.dtos;

import lombok.Data;

@Data
public class ResetPasswordRequestDto {
    private String login;
    private String newPassword;
}
