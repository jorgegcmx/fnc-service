package com.core.service.repositories;


import com.core.service.entities.Articulos;
import com.core.service.entities.Articulosdeprofecionales;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryArticulosDeProfecionales extends CrudRepository<Articulosdeprofecionales,Integer> {
    List<Articulosdeprofecionales> findByIdprofecional(Integer idProfesional);

    Articulosdeprofecionales findByNocertificadoAndEstatus(String cer, String estatus);

    Iterable<Articulosdeprofecionales> findAll(Sort id);

}
