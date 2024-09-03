package com.project.jwt.controller.dto;

import com.project.entities.enums.UserRole;

public record RegisterDTO(String name, String email, String phone, String password, UserRole role) {
}
