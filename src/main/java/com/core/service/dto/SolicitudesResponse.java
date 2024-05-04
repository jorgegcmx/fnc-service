package com.core.service.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class SolicitudesResponse {
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
    private String nombre;
    private String curso;
}
