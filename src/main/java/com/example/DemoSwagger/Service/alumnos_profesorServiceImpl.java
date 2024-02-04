package com.example.DemoSwagger.Service;

import com.example.DemoSwagger.Exception.EntityNotFoundException;
import com.example.DemoSwagger.Model.alumno_profesor;
import com.example.DemoSwagger.Repository.alumno_profesorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class alumnos_profesorServiceImpl implements alumnos_profesorService{
    @Autowired
    private alumno_profesorRepo Alumno_ProfesorRepo;
    @Override
    public List<alumno_profesor> getAllAlumnoProfesors() {
        return Alumno_ProfesorRepo.findAll();
    }

    @Override
    public Optional<alumno_profesor> getAlumnoProfesorById(Long id) {
        return Alumno_ProfesorRepo.findById(id);
    }

    @Override
    public alumno_profesor createAlumnoProfesor(alumno_profesor alumnoProfesor) {
        return Alumno_ProfesorRepo.save(alumnoProfesor);
    }

    @Override
    public alumno_profesor updateAlumnoProfesor(Long id, alumno_profesor alumnoProfesor) {
        alumnoProfesor.setId(id); // Asegúrate de que el ID de la entidad coincida con el proporcionado
        return Alumno_ProfesorRepo.save(alumnoProfesor);
    }

    @Override
    public void deleteAlumnoProfesor(Long id) {
        Alumno_ProfesorRepo.deleteById(id);
    }
}
