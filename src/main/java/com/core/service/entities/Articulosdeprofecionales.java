package com.core.service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}
