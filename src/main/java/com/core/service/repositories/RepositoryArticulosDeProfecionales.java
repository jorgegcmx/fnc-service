package com.core.service.repositories;

import com.core.service.entities.Agencias;
import com.core.service.entities.Articulosdeprofecionales;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryArticulosDeProfecionales extends CrudRepository<Articulosdeprofecionales,Long> {
}
