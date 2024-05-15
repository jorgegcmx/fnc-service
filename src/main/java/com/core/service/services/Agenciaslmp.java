package com.core.service.services;

import com.core.service.entities.Agencias;
import com.core.service.interfaces.AgenciasService;
import com.core.service.repositories.RepositoryAgencias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Agenciaslmp implements AgenciasService {

    @Autowired
    private RepositoryAgencias repositoryAgencias;
    @Override
    public List<Agencias> getAllAgencias(String nombre) {
        if(nombre.equalsIgnoreCase("1")){
            return (List<Agencias>) repositoryAgencias.findAll(Sort.by(Sort.Direction.DESC, "idclientes"));
        }else {
            return (List<Agencias>) repositoryAgencias.findByIdclientes(Integer.parseInt(nombre));
        }

    }

    @Override
    public List<Agencias> getAllAgenciasActivas() {
        return (List<Agencias>) repositoryAgencias.findByEstatusAndTipo("ACTIVA","AGENCIA");
    }

    @Override
    public Agencias getAgenciasById(Integer id) {
        try {
            return repositoryAgencias.findById(id).get();
        }catch (Exception e){
            return new Agencias();
        }
    }

    @Override
    public Agencias saveAgencias(Agencias agencias) {
        return repositoryAgencias.save(agencias);
    }
}
