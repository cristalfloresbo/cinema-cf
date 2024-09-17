package com.codigofacilito.peliculas.dao;

import com.codigofacilito.peliculas.entities.Pelicula;
import org.springframework.data.repository.CrudRepository;

public interface IPeliculaRepository extends CrudRepository<Pelicula, Long> {
}
