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
    public List<SolicitudesResponse> getAll(String nombre) {
        long inicio = System.currentTimeMillis();
        List<SolicitudesResponse> response = new ArrayList<>();
        List<SolicitudesResponse> responseByNombre = new ArrayList<>();
        try {
            Iterable<Articulosdeprofecionales> solicitudes = repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
            solicitudes.forEach((so) -> {
                SolicitudesResponse res = new SolicitudesResponse();
                SolicitudesResponse resByNombre = new SolicitudesResponse();
                String articulos = repositoryArticulos.buscaPorIdSoloNombre(so.getIdarticulo());
                String profecionales = repositoryProfecionales.buscaPorIdSoloNombre(so.getIdprofecional());
                //Agencias agencias = repositoryAgencias.findById(profecionales.getIdagencia()).get();
                res.setId(so.getId());
                res.setFecha(so.getFecha());
                res.setCosto(so.getCosto());
                res.setIdprofecional(so.getIdprofecional());
                res.setEstatus(so.getEstatus().equalsIgnoreCase("C") ? "CERTIFICADO" : "REGISTRADO");
                res.setIdarticulo(so.getIdarticulo());
                res.setNocertificado(so.getNocertificado());
                res.setEmail_pay(so.getEmail_pay());
                res.setId_pay(so.getId_pay());
                res.setMethod_pay(so.getMethod_pay());
                res.setNombre_pay(so.getNombre_pay());
                res.setTotal_pay(so.getTotal_pay());
                res.setStatus_pay(so.getStatus_pay());
                res.setNombre(profecionales);
                res.setCurso(articulos);
                response.add(res);
                if (res.getNombre().contains(nombre)) {
                    responseByNombre.add(res);
                }
            });

        } catch (Exception e) {
            return response;
        }
        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio) / 1000);
        System.out.println(tiempo + " segundos");

        return responseByNombre.isEmpty()?response:responseByNombre;
    }

    @Override
    public Articulosdeprofecionales getById(Integer id) {
        return null;
    }

    @Override
    public GuardaProfecionalResponse save(Articulosdeprofecionales articulos) {
        GuardaProfecionalResponse response = new GuardaProfecionalResponse();
        try {
            Optional<Articulosdeprofecionales> find = repository.findById(articulos.getId());
            if (find.isPresent()) {
                find.get().setFecha(articulos.getFecha());
                find.get().setNocertificado(articulos.getNocertificado());
                find.get().setEstatus("C");
                Articulosdeprofecionales registro = repository.save(find.get());
                if (registro != null) {
                    response.setArticulosdeprofecionales(registro);
                    response.setSmg("¡Atualización exitosa!");
                }
            } else {
                articulos.setFecha_registro(dateNow.FechaActual());
                Articulosdeprofecionales registro = repository.save(articulos);
                if (registro != null) {
                    response.setSmg("¡Se registro de forma correcta al curso !");
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
