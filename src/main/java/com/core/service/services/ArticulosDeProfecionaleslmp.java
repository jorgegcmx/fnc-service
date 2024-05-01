package com.core.service.services;


import com.core.service.dto.GuardaProfecionalResponse;
import com.core.service.entities.Articulosdeprofecionales;
import com.core.service.interfaces.ArticulosProfecionalesService;
import com.core.service.repositories.RepositoryArticulosDeProfecionales;
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
               response.setSmg("ok");
           }
       }catch (Exception e){
            response.setSmg("error");
       }
      return response;
    }
}
