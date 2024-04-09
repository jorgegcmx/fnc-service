package com.core.service.services;

import com.core.service.entities.Profecionales;
import com.core.service.interfaces.ProfecionalesService;
import com.core.service.repositories.RepositoryProfecionales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Profecionaleslmp implements ProfecionalesService {

    @Autowired
    private RepositoryProfecionales repository;
    @Override
    public List<Profecionales> getAllClientes() {
        return (List<Profecionales>) repository.findAll();
    }

    @Override
    public Profecionales getClientesById(Integer id) {
        return null;
    }

    @Override
    public void saveClientes(Profecionales profecionales) {
     repository.save(profecionales);
    }
}
