package com.example.DemoSwagger.Controller;

import com.example.DemoSwagger.Model.Materia;
import com.example.DemoSwagger.Service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("Materias")
public class MateriaController {
    @Autowired
    MateriaService materiaService;
    @GetMapping
    public ResponseEntity<List<Materia>> getAllMaterias() {
        List<Materia> materia = materiaService.getAllMaterias();
        return new ResponseEntity<>(materia, HttpStatus.OK);
    }
    @GetMapping("/buscarPorNombre")
    public ResponseEntity<List<Materia>> buscarMateriasPorNombre(@RequestParam String nombre) {
        List<Materia> materias = materiaService.findByNombre(nombre);
        return ResponseEntity.ok(materias);
    }
    @PostMapping
    public ResponseEntity<Materia> createMateria(@RequestBody Materia materia) {
        Materia createdMateria = materiaService.createOrUpdateMateria(materia);
        return new ResponseEntity<>(createdMateria, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Materia> updateMateria(@PathVariable Long id, @RequestBody Materia materia) {
        Materia updatedMateria = materiaService.updateMateria(id, materia);
        return ResponseEntity.ok(updatedMateria);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Materia> partialUpdateMateria(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Materia updatedMateria = materiaService.partialUpdateMateria(id, updates);
        return ResponseEntity.ok(updatedMateria);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlumno(@PathVariable Long id) {
        materiaService.deleteMateria(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
