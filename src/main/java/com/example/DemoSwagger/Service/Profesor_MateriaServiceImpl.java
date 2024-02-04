package com.example.DemoSwagger.Service;

import com.example.DemoSwagger.Exception.EntityNotFoundException;
import com.example.DemoSwagger.Model.Profesor_Materia;
import com.example.DemoSwagger.Model.Profesores;
import com.example.DemoSwagger.Repository.Profesor_MateriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class Profesor_MateriaServiceImpl implements Profesor_MateriaService{
    @Autowired
    private Profesor_MateriaRepo profesorMateriaRepository;

    @Override
    public List<Profesor_Materia> getAllProfesorMaterias() {
        return profesorMateriaRepository.findAll();
    }

    @Override
    public Optional<Profesor_Materia> getProfesorMateriaById(Long id) {
        return profesorMateriaRepository.findById(id);
    }

    @Override
    public Profesor_Materia createProfesorMateria(Profesor_Materia profesorMateria) {
        return profesorMateriaRepository.save(profesorMateria);
    }

    @Override
    public Profesor_Materia updateProfesorMateria(Long id, Profesor_Materia profesorMateria) {
        profesorMateria.setId(id);
        return profesorMateriaRepository.save(profesorMateria);
    }

    @Override
    public void deleteProfesorMateria(Long id) {
        profesorMateriaRepository.deleteById(id);
    }
}
