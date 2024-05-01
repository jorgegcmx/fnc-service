package com.core.service.interfaces;

import com.core.service.dto.GuardaProfecionalResponse;
import com.core.service.entities.Agencias;
import com.core.service.entities.Articulosdeprofecionales;

import java.util.List;

public interface ArticulosProfecionalesService {
    List<Articulosdeprofecionales> getAll();
    Articulosdeprofecionales getById(Integer id);
    GuardaProfecionalResponse save(Articulosdeprofecionales articulos);
}
