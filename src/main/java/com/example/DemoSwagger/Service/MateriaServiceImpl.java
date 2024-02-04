package com.example.DemoSwagger.Service;

import com.example.DemoSwagger.Exception.EntityNotFoundException;
import com.example.DemoSwagger.Model.Materia;
import com.example.DemoSwagger.Repository.MateriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MateriaServiceImpl implements MateriaService{
    @Autowired
    MateriaRepo materiaRepo;
    @Override
    public List<Materia> getAllMaterias() {
        return materiaRepo.findAll();
    }
    @Override
    public List<Materia> findByNombre(String nombre) {
        return materiaRepo.findByNombreContainingIgnoreCase(nombre);
    }
    @Override
    public Materia createOrUpdateMateria(Materia materia) {
        return materiaRepo.save(materia);
    }
    @Override
    public Materia updateMateria(Long id, Materia materia) {
        Materia existingMateria = materiaRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Materia with id " + id + " not found"));
        existingMateria.setNombre(materia.getNombre());
        return materiaRepo.save(existingMateria);
    }

    @Override
    public Materia partialUpdateMateria(Long id, Map<String, Object> updates) {
        Materia existingMateria = materiaRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Materia with id " + id + " not found"));

        updates.forEach((key, value) -> {
            switch (key) {
                case "Nombre":
                    existingMateria.setNombre((String) value);
                    break;
                // Agregar más casos para otros campos según sea necesario
            }
        });

        return materiaRepo.save(existingMateria);
    }
    @Override
    public void deleteMateria(Long id) {
        materiaRepo.deleteById(id);
    }
}
