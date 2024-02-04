package com.example.DemoSwagger.Service;

import com.example.DemoSwagger.Model.Alumnos;
import com.example.DemoSwagger.Model.Materia;

import java.util.List;
import java.util.Map;

public interface MateriaService {
    List<Materia> getAllMaterias();
    List<Materia> findByNombre(String nombre);
    Materia createOrUpdateMateria(Materia materia);
    Materia updateMateria(Long id, Materia materia);
    Materia partialUpdateMateria(Long id, Map<String, Object> updates);
    void deleteMateria(Long id);
}
