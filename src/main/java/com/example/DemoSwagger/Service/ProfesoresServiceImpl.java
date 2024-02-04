package com.example.DemoSwagger.Service;

import com.example.DemoSwagger.Exception.EntityNotFoundException;
import com.example.DemoSwagger.Model.Alumnos;
import com.example.DemoSwagger.Model.Profesores;
import com.example.DemoSwagger.Repository.AlumnosRepo;
import com.example.DemoSwagger.Repository.ProfesoresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProfesoresServiceImpl implements ProfesoresService{
    @Autowired
    private ProfesoresRepo profesoresRepo;
    @Autowired
    private AlumnosRepo alumnosRepo;

    public List<Profesores> getAllProfesores() {
        return profesoresRepo.findAll();
    }

    public Profesores getProfesorById(Long id) {
        return profesoresRepo.findById(id).orElse(null);
    }
    @Override
    public List<Profesores> findByNombre(String nombre) {
        return profesoresRepo.findByNombreContainingIgnoreCase(nombre);
    }

    public Profesores createOrUpdateProfesor(Profesores profesor) {
        return profesoresRepo.save(profesor);
    }
    @Override
    public Profesores updateProfesor(Long id, Profesores profesor) {
        Profesores existingProfesor = profesoresRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profesor with id " + id + " not found"));

        existingProfesor.setNombre(profesor.getNombre());
        existingProfesor.setEspecialidad(profesor.getEspecialidad());

        return profesoresRepo.save(existingProfesor);
    }

    @Override
    public Profesores partialUpdateProfesor(Long id, Map<String, Object> updates) {
        Profesores existingProfesor = profesoresRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profesor with id " + id + " not found"));
        updates.forEach((key, value) -> {
            switch (key) {
                case "nombre":
                    existingProfesor.setNombre((String) value);
                    break;
                case "especialidad":
                    existingProfesor.setEspecialidad((String) value);
                    break;
            }
        });
        return profesoresRepo.save(existingProfesor);
    }

    public void deleteProfesor(Long id) {
        profesoresRepo.deleteById(id);
    }

}
