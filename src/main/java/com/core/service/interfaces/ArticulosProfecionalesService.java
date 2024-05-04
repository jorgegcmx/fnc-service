package com.core.service.interfaces;

import com.core.service.dto.ConsultaCertificado;
import com.core.service.dto.GuardaProfecionalResponse;
import com.core.service.dto.SolicitudesResponse;
import com.core.service.entities.Agencias;
import com.core.service.entities.Articulosdeprofecionales;

import java.util.List;

public interface ArticulosProfecionalesService {
    List<SolicitudesResponse> getAll();
    Articulosdeprofecionales getById(Integer id);
    GuardaProfecionalResponse save(Articulosdeprofecionales articulos);
    ConsultaCertificado bucarCer(String cer);
}
