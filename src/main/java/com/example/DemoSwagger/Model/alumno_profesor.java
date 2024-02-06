package com.example.DemoSwagger.Model;

import javax.persistence.*;

@Entity
public class alumno_profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumnos alumno;
    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesores profesor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }

    public Profesores getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }

    public alumno_profesor(Long id, Alumnos alumno, Profesores profesor) {
        this.id = id;
        this.alumno = alumno;
        this.profesor = profesor;
    }

    public alumno_profesor() {
    }
}