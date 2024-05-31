package com.projeto.beneficiario.DTO;

import com.projeto.beneficiario.Models.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
