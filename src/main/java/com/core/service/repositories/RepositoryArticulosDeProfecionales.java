package com.core.service.repositories;


import com.core.service.entities.Articulos;
import com.core.service.entities.Articulosdeprofecionales;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryArticulosDeProfecionales extends CrudRepository<Articulosdeprofecionales,Integer> {
    List<Articulosdeprofecionales> findByIdprofecional(Integer idProfesional);
    Articulosdeprofecionales findByNocertificadoAndEstatus(String cer, String estatus);
    List<Articulosdeprofecionales> findAll(Sort id);
    List<Articulosdeprofecionales> findByNombreprofesionalContaining(String nombre);
    List<Articulosdeprofecionales> findByIdagenciaAndNombreprofesionalContaining(Integer idAgencia,String nombre);
    List<Articulosdeprofecionales> findByIdagencia(Integer idAgencia,Sort id);

   Optional<Articulosdeprofecionales>  findByIdprofecionalAndIdarticulo(Integer idProfesional, Integer idCurso);


}
