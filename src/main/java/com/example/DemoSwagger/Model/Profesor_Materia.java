package com.example.DemoSwagger.Model;

import  javax.persistence.*;

@Entity
public class Profesor_Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesores profesor;

    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profesores getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Profesor_Materia(Long id, Profesores profesor, Materia materia) {
        this.id = id;
        this.profesor = profesor;
        this.materia = materia;
    }

    public Profesor_Materia() {
    }
}
