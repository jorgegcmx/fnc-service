package com.core.service.interfaces;

import com.core.service.entities.Agencias;
import java.util.List;

public interface AgenciasService {
    List<Agencias> getAllAgencias();
    Agencias getAgenciasById(Integer id);
    Agencias saveAgencias(Agencias agencias);
}
