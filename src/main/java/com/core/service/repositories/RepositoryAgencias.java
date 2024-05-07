package com.core.service.repositories;

import com.core.service.entities.Agencias;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAgencias extends CrudRepository<Agencias,Integer> {
    Object findAll(Sort id);
}
