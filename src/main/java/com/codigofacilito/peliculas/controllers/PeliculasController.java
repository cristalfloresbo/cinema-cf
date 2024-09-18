package com.codigofacilito.peliculas.controllers;

import com.codigofacilito.peliculas.entities.Actor;
import com.codigofacilito.peliculas.entities.Pelicula;
import com.codigofacilito.peliculas.services.IActorService;
import com.codigofacilito.peliculas.services.IGeneroService;
import com.codigofacilito.peliculas.services.IPeliculaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class PeliculasController {

    private IPeliculaService peliculaService;
    private IGeneroService generoService;

    private IActorService actorService;

    public PeliculasController(IPeliculaService peliculaService, IGeneroService generoService, IActorService actorService) {
        this.peliculaService = peliculaService;
        this.generoService = generoService;
        this.actorService = actorService;
    }

    @GetMapping("/pelicula")
    public String crear(Model model) {
        Pelicula pelicula = new Pelicula();
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("generos", generoService.findAll());
        model.addAttribute("actores", actorService.findAll());
        model.addAttribute("titulo", "Nueva Pelicula");

        return "pelicula";
    }

    @GetMapping("/pelicula/{id}")
    public String edit(@PathVariable(name = "id") Long id, Model model) {
        Pelicula pelicula = new Pelicula();
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("generos", generoService.findAll());
        model.addAttribute("titulo", "Nueva Pelicula");

        return "pelicula";
    }

    // BindingResult tiene almacenado las validaciones del formulario.
    @PostMapping("/pelicula")
    public String guardar(@Valid Pelicula pelicula, BindingResult br, @ModelAttribute(name = "ids") String ids, Model model) {

        if(br.hasErrors()) {
            model.addAttribute("pelicula", pelicula);
            model.addAttribute("generos", generoService.findAll());
            return "/pelicula";
        }

        List<Long> idsProtagonistas = Arrays.stream(ids.split(","))
                .map(Long::parseLong).toList();
        List<Actor> protagonistas = actorService.findAllById(idsProtagonistas);
        pelicula.setProtagonistas(protagonistas);
        peliculaService.save(pelicula);
        return "redirect:home";
    }

    @GetMapping({"/", "home", "index"})
    public String home() {
        return "home";
    }
}
