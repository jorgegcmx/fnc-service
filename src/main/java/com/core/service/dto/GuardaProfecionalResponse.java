package com.core.service.dto;

import com.core.service.entities.Articulosdeprofecionales;
import lombok.Data;

@Data
public class GuardaProfecionalResponse {
    private Articulosdeprofecionales articulosdeprofecionales;
    private String smg;
}
