package com.example.DemoSwagger.Controller;

import com.example.DemoSwagger.Exception.EntityNotFoundException;
import com.example.DemoSwagger.Model.Profesor_Materia;
import com.example.DemoSwagger.Repository.Profesor_MateriaRepo;
import com.example.DemoSwagger.Service.Profesor_MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("Profesor_Materia")
public class Profesor_MateriaController {
    @Autowired
    private Profesor_MateriaService profesorMateriaService;

    @GetMapping
    public List<Profesor_Materia> getAllProfesorMaterias() {
        return profesorMateriaService.getAllProfesorMaterias();
    }

    @GetMapping("/{id}")
    public Profesor_Materia getProfesorMateriaById(@PathVariable Long id) {
        return profesorMateriaService.getProfesorMateriaById(id)
                .orElseThrow(() -> new EntityNotFoundException("Materia with id " + id + " not found"));
    }

    @PostMapping
    public Profesor_Materia createProfesorMateria(@RequestBody Profesor_Materia profesorMateria) {
        return profesorMateriaService.createProfesorMateria(profesorMateria);
    }

    @PutMapping("/{id}")
    public Profesor_Materia updateProfesorMateria(@PathVariable Long id, @RequestBody Profesor_Materia profesorMateria) {
        return profesorMateriaService.updateProfesorMateria(id, profesorMateria);
    }

    @DeleteMapping("/{id}")
    public void deleteProfesorMateria(@PathVariable Long id) {
        profesorMateriaService.deleteProfesorMateria(id);
    }
}