package com.core.service.repositories;

import com.core.service.entities.Articulos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryArticulos extends CrudRepository<Articulos,Long> {
}
