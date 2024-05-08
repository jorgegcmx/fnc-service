package com.core.service.dto;

import lombok.Data;

@Data
public class LoginResponse {
    private Boolean isLogged;
    private Integer userId;
    private String user;
    private Boolean permisos;
    private String perfil;
}
