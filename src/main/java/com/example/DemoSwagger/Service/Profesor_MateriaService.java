package com.example.DemoSwagger.Service;

import com.example.DemoSwagger.Model.Profesor_Materia;
import com.example.DemoSwagger.Model.alumno_profesor;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Profesor_MateriaService {
    List<Profesor_Materia> getAllProfesorMaterias();
    Optional<Profesor_Materia> getProfesorMateriaById(Long id);
    Profesor_Materia createProfesorMateria(Profesor_Materia profesorMateria);
    Profesor_Materia updateProfesorMateria(Long id, Profesor_Materia profesorMateria);
    void deleteProfesorMateria(Long id);
}
