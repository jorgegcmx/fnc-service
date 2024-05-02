package com.core.service.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class Cursos {
    private String curso;
    private String nocertificado;
    private Date fecha;
    private String estatus;
    private String codigo;
    private String descripcion;
    private Date fecha_registro;
    private String id_pay;
    private String status_pay;
    private String nombre_pay;
    private String email_pay;
    private String total_pay;
    private String method_pay;
}
