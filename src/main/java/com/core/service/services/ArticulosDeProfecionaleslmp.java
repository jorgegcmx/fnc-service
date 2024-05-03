package com.core.service.services;


import com.core.service.dto.ConsultaCertificado;
import com.core.service.dto.GuardaProfecionalResponse;
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
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Articulosdeprofecionales> getAll() {
        return (List<Articulosdeprofecionales>) repository.findAll();
    }

    @Override
    public Articulosdeprofecionales getById(Integer id) {
        return null;
    }

    @Override
    public GuardaProfecionalResponse save(Articulosdeprofecionales articulos) {
        GuardaProfecionalResponse response= new  GuardaProfecionalResponse();
        try {
            articulos.setFecha_registro(dateNow.FechaActual());
           Articulosdeprofecionales registro = repository.save(articulos);
           if(registro != null){
               response.setSmg("¡Se registro de forma correcta al curso !");
           }
       }catch (Exception e){
            response.setSmg("error");
       }
      return response;
    }


    @Override
    public ConsultaCertificado bucarCer(String cer) {
        ConsultaCertificado certificado = new ConsultaCertificado();
        try {
            Articulosdeprofecionales articulosdeprofecionales =  repository.findByNocertificado(cer.trim());
            Profecionales profecionales= repositoryProfecionales.findById(articulosdeprofecionales.getIdprofecional()).get();
            Agencias agencias = repositoryAgencias.findById(profecionales.getIdagencia()).get();
            Articulos articulos = repositoryArticulos.findById(articulosdeprofecionales.getIdarticulo()).get();
            certificado.setCertificado(articulosdeprofecionales);
            certificado.setAgencias(agencias);
            certificado.setProfecionales(profecionales);
            certificado.setArticulos(articulos);
            certificado.setSmg("success");
        }catch (Exception e){
            certificado.setAgencias(new Agencias());
            certificado.setProfecionales(new Profecionales());
            certificado.setCertificado(new Articulosdeprofecionales());
            certificado.setSmg("¡El Numero de Certificado no es valido!");
        }
        return certificado;
    }
}
