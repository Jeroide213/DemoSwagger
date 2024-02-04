package com.example.DemoSwagger.Service;

import com.example.DemoSwagger.Exception.AlumnoNotFoundException;
import com.example.DemoSwagger.Model.Alumnos;
import com.example.DemoSwagger.Model.Profesores;
import com.example.DemoSwagger.Repository.AlumnosRepo;
import com.example.DemoSwagger.Repository.ProfesoresRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class AlumnosServiceImpl implements AlumnosService{
    @Autowired
    private AlumnosRepo alumnosRepo;
    @Autowired
    private ProfesoresRepo profesoresRepo;

    public List<Alumnos> getAllAlumnos() {
        return alumnosRepo.findAll();
    }
    @Override
    public List<Alumnos> findByNombre(String nombre) {
        return alumnosRepo.findByNombreContainingIgnoreCase(nombre);
    }

    public Alumnos getAlumnoById(Long id) {
        return alumnosRepo.findById(id).orElse(null);
    }

    public Alumnos createOrUpdateAlumno(Alumnos alumno) {
        return alumnosRepo.save(alumno);
    }
    @Override
    public Alumnos updateAlumno(Long id, Alumnos alumno) {
        Alumnos alumnoExistente = alumnosRepo.findById(id)
                .orElseThrow(() -> new AlumnoNotFoundException("Alumno with id " + id + " not found"));

        alumnoExistente.setNombre(alumno.getNombre());
        alumnoExistente.setEdad(alumno.getEdad());
        return alumnosRepo.save(alumnoExistente);
    }
    @Override
    public Alumnos partialUpdateAlumno(Long id, Map<String, Object> updates) {
        Alumnos alumnoExistente = alumnosRepo.findById(id)
                .orElseThrow(() -> new AlumnoNotFoundException("Alumno with id " + id + " not found"));

        updates.forEach((key, value) -> {
            switch (key) {
                case "nombre":
                    alumnoExistente.setNombre((String) value);
                    break;
                case "edad":
                    alumnoExistente.setEdad((Integer) value);
                    break;
            }
        });
        return alumnosRepo.save(alumnoExistente);
    }
    public void deleteAlumno(Long id) {
        alumnosRepo.deleteById(id);
    }
}
