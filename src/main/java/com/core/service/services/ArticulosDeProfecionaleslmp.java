package com.core.service.services;


import com.core.service.entities.Articulosdeprofecionales;
import com.core.service.interfaces.ArticulosProfecionalesService;
import com.core.service.repositories.RepositoryArticulosDeProfecionales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticulosDeProfecionaleslmp implements ArticulosProfecionalesService {

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
    public void save(Articulosdeprofecionales articulos) {

    }
}
