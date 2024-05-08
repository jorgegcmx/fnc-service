package com.core.service.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
@Entity
public class Articulosdeprofecionales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idarticulo;
    private String nocertificado;
    private Date fecha;
    private Double costo;
    private Integer idprofecional;
    private String estatus;
    private Date fecha_registro;
    private String id_pay;
    private String status_pay;
    private String nombre_pay;
    private String email_pay;
    private String total_pay;
    private String method_pay;
    @Column(name="nombre_profesional")
    private String nombreprofesional;
    @Column(name="nombre_curso")
    private String nombrecurso;
    @Column(name="nombre_agencia")
    private String nombreagencia;
    @Column(name="id_agencia")
    private Integer idagencia;
}
