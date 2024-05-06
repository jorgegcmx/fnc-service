package com.core.service.repositories;

import com.core.service.entities.Articulos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryArticulos extends CrudRepository<Articulos,Integer> {
    List<Articulos> findByNombreContaining(String nombre);

    @Query(value = "SELECT nombre FROM articulos  WHERE idarticulos = ?1", nativeQuery = true)
    public String buscaPorIdSoloNombre(Integer id);
}
