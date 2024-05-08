package com.core.service.services;


import com.core.service.dto.ConsultaCertificado;
import com.core.service.dto.GuardaProfecionalResponse;
import com.core.service.dto.SolicitudesResponse;
import com.core.service.entities.Agencias;
import com.core.service.entities.Articulos;
import com.core.service.entities.Articulosdeprofecionales;
import com.core.service.entities.Profecionales;
import com.core.service.interfaces.ArticulosProfecionalesService;
import com.core.service.repositories.RepositoryAgencias;
import com.core.service.repositories.RepositoryArticulos;
import com.core.service.repositories.RepositoryArticulosDeProfecionales;
import com.core.service.repositories.RepositoryProfecionales;
import com.core.service.utils.DateNow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ArticulosDeProfecionaleslmp implements ArticulosProfecionalesService {
    @Autowired
    private DateNow dateNow;
    @Autowired
    private RepositoryArticulosDeProfecionales repository;

    @Autowired
    private RepositoryProfecionales repositoryProfecionales;

    @Autowired
    private RepositoryAgencias repositoryAgencias;

    @Autowired
    private RepositoryArticulos repositoryArticulos;

    @Override
    public List<Articulosdeprofecionales> getAll(String nombre) {
        List<Articulosdeprofecionales> response = new ArrayList<>();
        try {
            if (nombre.equalsIgnoreCase("1")) {
                response = repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
            } else {
                response = repository.findByNombreprofesionalContaining(nombre);
            }
        } catch (Exception e) {
            return response;
        }
        return response;
    }

    @Override
    public List<Articulosdeprofecionales> getByAgenciaId(Integer id, String nombre) {
        List<Articulosdeprofecionales> response = new ArrayList<>();
        try {
            if (nombre.equalsIgnoreCase("1")) {
                response = repository.findByIdagencia(id,Sort.by(Sort.Direction.DESC, "id"));
            } else {
                response = repository.findByIdagenciaAndNombreprofesionalContaining(id, nombre);
            }

        } catch (Exception e) {
            return response;
        }
        return response;
    }

    @Override
    public GuardaProfecionalResponse save(Articulosdeprofecionales articulos) {
        GuardaProfecionalResponse response = new GuardaProfecionalResponse();
        try {
            if(articulos.getId() != null && articulos.getEstatus()!=null){
                Optional<Articulosdeprofecionales> find = repository.findById(articulos.getId());
                if (find.isPresent()) {
                    find.get().setEmail_pay(articulos.getEmail_pay());
                    find.get().setId_pay(articulos.getId_pay());
                    find.get().setNombre_pay(articulos.getNombre_pay());
                    find.get().setStatus_pay(articulos.getStatus_pay());
                    find.get().setMethod_pay(articulos.getMethod_pay());
                    find.get().setTotal_pay(articulos.getTotal_pay());
                    Articulosdeprofecionales registro = repository.save(find.get());
                    if (registro != null) {
                        response.setArticulosdeprofecionales(registro);
                        response.setSmg("¡El pago se registro correctamente!");
                        return response;
                    }
                }
            }

            if (articulos.getId() != null) {
                Optional<Articulosdeprofecionales> find = repository.findById(articulos.getId());
                if (find.isPresent()) {
                    find.get().setFecha(articulos.getFecha());
                    find.get().setNocertificado(articulos.getNocertificado());
                    find.get().setEstatus("C");
                    Articulosdeprofecionales registro = repository.save(find.get());
                    if (registro != null) {
                        response.setArticulosdeprofecionales(registro);
                        response.setSmg("¡Atualización exitosa!");
                        return response;
                    }
                }
            }

                Optional<Articulosdeprofecionales> existe = repository.findByIdprofecionalAndIdarticulo(articulos.getIdprofecional(), articulos.getIdarticulo());
                if (existe.isPresent()) {
                    response.setSmg("¡Ya te encuentras registrado en este curso!");
                } else {
                    articulos.setFecha_registro(dateNow.FechaActual());
                    articulos.setNombrecurso(repositoryArticulos.buscaPorIdSoloNombre(articulos.getIdarticulo()));
                    articulos.setNombreprofesional(repositoryProfecionales.buscaPorIdSoloNombre(articulos.getIdprofecional()));
                    articulos.setIdagencia(repositoryProfecionales.buscaPorIdSoloAgenciaId(articulos.getIdprofecional()));
                    Agencias agencias = repositoryAgencias.findById(articulos.getIdagencia()).get();
                    articulos.setNombreagencia(agencias.getRazon_social());
                    Articulosdeprofecionales registro = repository.save(articulos);
                    if (registro != null) {
                        response.setSmg("¡Se registro de forma correcta al curso !");
                        return response;
                    }
                }

        } catch (Exception e) {
            response.setSmg("error");
        }
        return response;
    }


    @Override
    public ConsultaCertificado bucarCer(String cer) {
        ConsultaCertificado certificado = new ConsultaCertificado();
        try {
            Articulosdeprofecionales articulosdeprofecionales = repository.findByNocertificadoAndEstatus(cer.trim(), "C");
            Profecionales profecionales = repositoryProfecionales.findById(articulosdeprofecionales.getIdprofecional()).get();
            Agencias agencias = repositoryAgencias.findById(profecionales.getIdagencia()).get();
            Articulos articulos = repositoryArticulos.findById(articulosdeprofecionales.getIdarticulo()).get();
            certificado.setCertificado(articulosdeprofecionales);
            certificado.setAgencias(agencias);
            certificado.setProfecionales(profecionales);
            certificado.setArticulos(articulos);
            certificado.setSmg("success");
        } catch (Exception e) {
            certificado.setAgencias(new Agencias());
            certificado.setProfecionales(new Profecionales());
            certificado.setCertificado(new Articulosdeprofecionales());
            certificado.setSmg("¡El Numero de Certificado no es valido!");
        }
        return certificado;
    }
}
