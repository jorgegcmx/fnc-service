package com.core.service.repositories;

import com.core.service.entities.Profecionales;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProfecionales extends CrudRepository<Profecionales,Long> {
Profecionales findByEmailcliente(String email);
Profecionales findByEmailclienteAndPassword(String email, String password);
}
