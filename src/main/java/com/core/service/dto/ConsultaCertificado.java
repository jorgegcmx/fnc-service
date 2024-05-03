package com.core.service.dto;

import com.core.service.entities.Agencias;
import com.core.service.entities.Articulos;
import com.core.service.entities.Articulosdeprofecionales;
import com.core.service.entities.Profecionales;
import lombok.Data;

@Data
public class ConsultaCertificado {
    private Articulosdeprofecionales certificado;
    private Profecionales  profecionales;
    private Agencias agencias;
    private Articulos articulos;
    private String smg;
}
