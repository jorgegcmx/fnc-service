package com.core.service.repositories;


import com.core.service.entities.Articulosdeprofecionales;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryArticulosDeProfecionales extends CrudRepository<Articulosdeprofecionales,Long> {
    List<Articulosdeprofecionales> findByIdprofecional(Integer idProfesional);

    Articulosdeprofecionales findByNocertificado(String cer);
}
