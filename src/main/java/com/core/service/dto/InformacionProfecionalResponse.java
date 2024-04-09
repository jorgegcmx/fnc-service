package com.core.service.dto;

import com.core.service.entities.Agencias;
import com.core.service.entities.Articulosdeprofecionales;
import lombok.Data;
import java.sql.Date;
import java.util.List;

@Data
public class InformacionProfecionalResponse {
    private Integer idprofecional;
    private Date fecha;
    private String status;
    private String password;
    private String nombrecliente;
    private String email_cliente;
    private Agencias agencia;
    private List<Cursos> cursos;
}
