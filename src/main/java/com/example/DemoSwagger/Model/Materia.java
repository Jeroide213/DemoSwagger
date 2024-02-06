package com.example.DemoSwagger.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import  javax.persistence.*;

import java.util.List;

@Entity
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "profesor_materia",
            joinColumns = @JoinColumn(name = "materia_id"),
            inverseJoinColumns = @JoinColumn(name = "profesor_id")
    )
    private List<Profesores> profesores;

    public Materia(Long id, String nombre, List<Profesores> profesores) {
        this.id = id;
        nombre = nombre;
        this.profesores = profesores;
    }

    public Materia() {
    }

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
        nombre = nombre;
    }

    public List<Profesores> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesores> profesores) {
        this.profesores = profesores;
    }
}
