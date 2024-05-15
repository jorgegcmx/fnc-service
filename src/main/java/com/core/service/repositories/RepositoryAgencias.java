package com.core.service.repositories;

import com.core.service.entities.Agencias;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryAgencias extends CrudRepository<Agencias,Integer> {
    Object findAll(Sort id);
    List<Agencias> findByIdclientes(Integer id);
    @Query(value = "SELECT * FROM agencias  WHERE email_cliente = ?1 and contrasena_cliente =?2", nativeQuery = true)
    public Agencias login(String email, String contrasena);
}
