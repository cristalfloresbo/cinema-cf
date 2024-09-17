package com.codigofacilito.peliculas.services;

import com.codigofacilito.peliculas.dao.IActorRepository;
import com.codigofacilito.peliculas.entities.Actor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService {

    private IActorRepository repository;

    @Override
    public List<Actor> findAll() {
        return (List<Actor>) repository.findAll();
    }

    @Override
    public List<Actor> findAllById(List<Long> ids) {
        return (List<Actor>) repository.findAllById(ids);
    }
}
