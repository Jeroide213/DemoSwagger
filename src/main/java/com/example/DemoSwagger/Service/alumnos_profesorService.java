package com.example.DemoSwagger.Service;

import com.example.DemoSwagger.Model.alumno_profesor;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface alumnos_profesorService {
    List<alumno_profesor> getAllAlumnoProfesors();
    Optional<alumno_profesor> getAlumnoProfesorById(Long id);
    alumno_profesor createAlumnoProfesor(alumno_profesor alumnoProfesor);
    alumno_profesor updateAlumnoProfesor(Long id, alumno_profesor alumnoProfesor);
    void deleteAlumnoProfesor(Long id);
}
