package com.core.service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Agencias {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer idclientes;
    private String email_cliente;
    private String contrasena_cliente;
    private String telefono;
    private String direccion;
    private String pais;
    private String estado;
    private String municipio;
    private String rfc;
    private String razon_social;
    private Integer idusuarios_admin;
}
