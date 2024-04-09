package com.core.service.interfaces;

import com.core.service.dto.Cursos;
import com.core.service.dto.InformacionProfecionalResponse;
import com.core.service.entities.Agencias;
import com.core.service.entities.Articulos;
import com.core.service.entities.Articulosdeprofecionales;

import java.util.List;

public  interface  InformacionProfesionalService {
     List<InformacionProfecionalResponse> getallProfesionales();
     List<Cursos> getCursos(Integer idProfecional);
     Agencias getAgencias(Integer idAgencia);
     Articulos getArticulo(Integer idArticulo);
}
