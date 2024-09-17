package com.codigofacilito.peliculas.dao;

import com.codigofacilito.peliculas.entities.Genero;

public interface IGeneroRepository {

    public void save(Genero genero);

    public Genero findById(Long id);
}
