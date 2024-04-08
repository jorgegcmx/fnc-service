package com.core.service.services;

import com.core.service.entities.Agencias;
import com.core.service.interfaces.AgenciasService;
import com.core.service.repositories.RepositoryAgencias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Agenciaslmp implements AgenciasService {

    @Autowired
    private RepositoryAgencias repositoryAgencias;
    @Override
    public List<Agencias> getAllAgencias() {
        return (List<Agencias>) repositoryAgencias.findAll();
    }

    @Override
    public Agencias getAgenciasById(Integer id) {
        return null;
    }

    @Override
    public void saveAgencias(Agencias articulos) {

    }
}
