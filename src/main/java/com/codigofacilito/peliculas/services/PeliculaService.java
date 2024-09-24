package com.codigofacilito.peliculas.services;

import com.codigofacilito.peliculas.dao.IPeliculaRepository;
import com.codigofacilito.peliculas.entities.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService implements IPeliculaService {

    @Autowired
    private IPeliculaRepository repository;

    @Override
    public void save(Pelicula pelicula) {
        repository.save(pelicula);
    }

    @Override
    public Pelicula findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Pelicula> findAll() {
        return (List<Pelicula>) repository.findAll();
    }

    @Override
    public Page<Pelicula> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
