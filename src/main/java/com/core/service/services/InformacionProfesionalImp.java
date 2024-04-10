package com.core.service.services;


import com.core.service.dto.Cursos;
import com.core.service.dto.InformacionProfecionalResponse;
import com.core.service.entities.Agencias;
import com.core.service.entities.Articulos;
import com.core.service.entities.Articulosdeprofecionales;
import com.core.service.interfaces.InformacionProfesionalService;
import com.core.service.repositories.RepositoryAgencias;
import com.core.service.repositories.RepositoryArticulos;
import com.core.service.repositories.RepositoryArticulosDeProfecionales;
import com.core.service.repositories.RepositoryProfecionales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class InformacionProfesionalImp implements InformacionProfesionalService {

    @Autowired
    private RepositoryProfecionales profecionales;
    @Autowired
    private RepositoryAgencias agencias;
    @Autowired
    private RepositoryArticulosDeProfecionales cursosdetalle;
    @Autowired
    private RepositoryArticulos articulos;

    @Override
    @Transactional
    public List<InformacionProfecionalResponse> getallProfesionales() {
        List<InformacionProfecionalResponse> list = new ArrayList<>();
        profecionales.findAll().forEach((profecionales) -> {
            InformacionProfecionalResponse profecionalResponse = new InformacionProfecionalResponse();
            profecionalResponse.setIdprofecional(profecionales.getIdprofecional());
            profecionalResponse.setFecha(profecionales.getFecha());
            profecionalResponse.setPassword(profecionales.getPassword());
            profecionalResponse.setEmail_cliente(profecionales.getEmailcliente());
            profecionalResponse.setStatus(validaEstatus(profecionales.getStatus()));
            profecionalResponse.setNombrecliente(profecionales.getNombrecliente());
            Agencias agn = getAgencias(profecionales.getIdagencia());
            profecionalResponse.setAgencia(agn);
            List<Cursos> cursos = getCursos(profecionales.getIdprofecional());
            profecionalResponse.setCursos(cursos);
            list.add(profecionalResponse);
        });
        return list;
    }

    @Override
    public List<Cursos> getCursos(Integer idProfecional) {
        List<Cursos> listas = new ArrayList<>();
        List<Articulosdeprofecionales> detalle = cursosdetalle.findByIdprofecional(idProfecional);
        detalle.forEach((datos) -> {
            Cursos cursos = new Cursos();
            Articulos art = getArticulo(datos.getIdarticulo());
            cursos.setCurso(art.getNombre());
            cursos.setCodigo(art.getCodigo());
            cursos.setDescripcion(art.getDescripcion());
            cursos.setFecha(datos.getFecha());
            cursos.setEstatus(validaEstatus(datos.getEstatus()));
            cursos.setNocertificado(datos.getNocertificado());
            listas.add(cursos);
        });
        return listas;
    }

    @Override
    public Agencias getAgencias(Integer idAgencia) {
        return agencias.findById(idAgencia.longValue()).get();
    }

    @Override
    public Articulos getArticulo(Integer idArticulo) {
        return articulos.findById(idArticulo.longValue()).get();
    }

    public String validaEstatus(String estatus) {
        return switch (estatus) {
            case "A" -> "Activo";
            case "C" -> "Certificado";
            case "R" -> "Registrado";
            case "B" -> "Bloqueado";
            default -> "Unknown";
        };
    }
}
