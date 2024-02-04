package com.example.DemoSwagger.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Profesores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String especialidad;

    @JsonIgnore
    @ManyToMany(mappedBy = "profesores")
    private List<Alumnos> alumnos;
    @JsonIgnore
    @ManyToMany(mappedBy = "profesores")
    private List<Materia> materia;

    public Profesores(Long id, String nombre, String especialidad, List<Alumnos> alumnos, List<Materia> materia) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.alumnos = alumnos;
        this.materia = materia;
    }

    public Profesores() {
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
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Alumnos> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumnos> alumnos) {
        this.alumnos = alumnos;
    }

    public List<Materia> getMateria() {
        return materia;
    }

    public void setMateria(List<Materia> materia) {
        this.materia = materia;
    }
}
