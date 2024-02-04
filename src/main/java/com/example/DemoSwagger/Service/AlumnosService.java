package com.example.DemoSwagger.Service;

import com.example.DemoSwagger.Model.Alumnos;

import java.util.List;
import java.util.Map;

public interface AlumnosService {
    List<Alumnos>getAllAlumnos();
    List<Alumnos> findByNombre(String nombre);
    Alumnos getAlumnoById(Long id);
    Alumnos createOrUpdateAlumno(Alumnos alumno);
    Alumnos updateAlumno(Long id, Alumnos alumno);
    Alumnos partialUpdateAlumno(Long id, Map<String, Object> updates);
    void deleteAlumno(Long id);
}
