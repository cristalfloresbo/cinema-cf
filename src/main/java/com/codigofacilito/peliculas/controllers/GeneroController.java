package com.codigofacilito.peliculas.controllers;

import com.codigofacilito.peliculas.dao.IGeneroRepository;
import com.codigofacilito.peliculas.entities.Genero;
import org.springframework.web.bind.annotation.*;

@RestController
public class GeneroController {

    private IGeneroRepository generoRepository;

    public GeneroController(IGeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    @PostMapping("genero")
    public Long guardar(@RequestParam String nombre) {
        Genero genero = new Genero();
        genero.setNombre(nombre);

        generoRepository.save(genero);

        return genero.getId();
    }

    @GetMapping("genero/{id}")
    public String buscarPorId(@PathVariable(name = "id") Long id) {
        return generoRepository.findById(id).getNombre();
    }
}
