package com.codigofacilito.peliculas.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "peliculas")
public class Pelicula implements Serializable {

    private static final long serialVersionUID = -4623764282362001928L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre no debe ser vacio")
    private String nombre;
    @Column(name = "fecha_estreno")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "El campo fecha estreno no debe estar vacio")
    private Date fechaEstreno;

    @NotNull
    @ManyToOne
    private Genero genero;

    @ManyToMany
    private List<Actor> protagonistas;

    private String imagen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Actor> getProtagonistas() {
        return protagonistas;
    }

    public void setProtagonistas(List<Actor> protagonistas) {
        this.protagonistas = protagonistas;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
