package com.core.service.interfaces;

import com.core.service.entities.Articulos;

import java.util.List;

public interface ArticulosServices {
    List<Articulos> getAllArticulos(String nombre);
    Articulos getArticulosById(Integer id);
    void saveArticulos(Articulos articulos);

}
