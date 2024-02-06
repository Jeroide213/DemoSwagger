package com.example.DemoSwagger.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import  javax.persistence.*;

import java.util.List;

@Entity
public class Alumnos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int edad;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "alumno_profesor",
            joinColumns = @JoinColumn(name = "alumno_id"),
            inverseJoinColumns = @JoinColumn(name = "profesor_id")
    )
    private List<Profesores> profesores;

    public Alumnos() {
    }

    public Alumnos(Long id, String nombre, int edad, List<Profesores> profesores) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.profesores = profesores;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Profesores> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesores> profesores) {
        this.profesores = profesores;
    }
}
