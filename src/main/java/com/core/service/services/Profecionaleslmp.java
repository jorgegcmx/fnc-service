package com.core.service.services;

import com.core.service.dto.GuardaProfecionalResponse;
import com.core.service.entities.Profecionales;
import com.core.service.interfaces.EmailService;
import com.core.service.interfaces.ProfecionalesService;
import com.core.service.repositories.RepositoryProfecionales;
import com.core.service.utils.DateNow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class Profecionaleslmp implements ProfecionalesService {

    @Autowired
    private  DateNow dateNow;
    @Autowired
    private RepositoryProfecionales repository;

    @Autowired
    private EmailService serviceEmail;

    @Override
    public List<Profecionales> getAllClientes() {
        return (List<Profecionales>) repository.findAll();
    }

    @Override
    public Profecionales getClientesById(Integer id) {
        return null;
    }

    @Override
    public GuardaProfecionalResponse saveClientes(Profecionales profecionales) {
        GuardaProfecionalResponse response = new GuardaProfecionalResponse();
        try {
           Profecionales pro = repository.findByEmailcliente(profecionales.getEmailcliente());
           if (pro == null) {
               profecionales.setFecha(dateNow.FechaActual());
               Profecionales guardado = repository.save(profecionales);
                  if(guardado != null){
                      serviceEmail.sendEmail(profecionales.getEmailcliente());
                  }
               response.setSmg("¡Se registro de forma correcta!");
           }else {
               response.setSmg("¡Erro ya existe un registro con este email!");
           }
       }catch (Exception e){
           response.setSmg("¡Error al registrar cuenta!");
       }
        return response;
    }
}
