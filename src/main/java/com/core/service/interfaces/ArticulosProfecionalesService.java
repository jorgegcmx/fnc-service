package com.core.service.interfaces;

import com.core.service.dto.ConsultaCertificado;
import com.core.service.dto.GuardaProfecionalResponse;
import com.core.service.dto.SolicitudesResponse;
import com.core.service.entities.Agencias;
import com.core.service.entities.Articulosdeprofecionales;

import java.util.List;

public interface ArticulosProfecionalesService {
    List<Articulosdeprofecionales> getAll(String nombre);
    List<Articulosdeprofecionales> getByAgenciaId(Integer id, String nombre);
    GuardaProfecionalResponse save(Articulosdeprofecionales articulos);
    ConsultaCertificado bucarCer(String cer);
}
