package com.core.service.interfaces;

import com.core.service.dto.GuardaProfecionalResponse;
import com.core.service.entities.Profecionales;

import java.util.List;

public interface ProfecionalesService {
    List<Profecionales> getAllClientes();
    Profecionales getClientesById(Integer id);
    GuardaProfecionalResponse saveClientes(Profecionales profecionales);

}
