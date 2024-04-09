package com.core.service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
public class Profecionales {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idprofecional;
    private Date fecha;
    private Integer idagencia;
    private String status;
    private String password;
    private String nombrecliente;
    private String email_cliente;
}
