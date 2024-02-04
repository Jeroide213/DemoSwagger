package com.example.DemoSwagger.Service;

import com.example.DemoSwagger.Model.Profesores;

import java.util.List;
import java.util.Map;

public interface ProfesoresService {
    List<Profesores> getAllProfesores();
    Profesores getProfesorById(Long id);
    List<Profesores> findByNombre(String nombre);
    Profesores createOrUpdateProfesor(Profesores profesor);
    Profesores updateProfesor(Long id, Profesores profesor);
    Profesores partialUpdateProfesor(Long id, Map<String, Object> updates);
    void deleteProfesor(Long id);
}
