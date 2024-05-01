package com.core.service.services;

import com.core.service.entities.Articulos;
import com.core.service.interfaces.ArticulosServices;
import com.core.service.repositories.RepositoryArticulos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Articuloslmp implements ArticulosServices {

    @Autowired
    private RepositoryArticulos repositoryArticulos;
    @Override
    public List<Articulos> getAllArticulos(String nombre) {
        List<Articulos> lista = new ArrayList<>();
        if(nombre.equalsIgnoreCase("1")){
            lista = (List<Articulos>) repositoryArticulos.findAll();
        }else{
            lista =repositoryArticulos.findByNombreContaining(nombre);
        }
       return  lista;
    }

    @Override
    public Articulos getArticulosById(Integer id) {
        return null;
    }

    @Override
    public void saveArticulos(Articulos articulos) {

    }
}
