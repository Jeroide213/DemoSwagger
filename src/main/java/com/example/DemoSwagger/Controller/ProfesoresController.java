package com.example.DemoSwagger.Controller;

import com.example.DemoSwagger.Model.Profesores;
import com.example.DemoSwagger.Service.ProfesoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/profesores")
public class ProfesoresController {
    @Autowired
    private ProfesoresService profesorService;

    @GetMapping
    public ResponseEntity<List<Profesores>> getAllProfesores() {
        List<Profesores> profesores = profesorService.getAllProfesores();
        return new ResponseEntity<>(profesores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesores> getProfesorById(@PathVariable Long id) {
        Profesores profesor = profesorService.getProfesorById(id);
        if (profesor != null) {
            return new ResponseEntity<>(profesor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/buscarPorNombre")
    public ResponseEntity<List<Profesores>> buscarProfesoresPorNombre(@RequestParam String nombre) {
        List<Profesores> profesores = profesorService.findByNombre(nombre);
        return ResponseEntity.ok(profesores);
    }

    @PostMapping
    public ResponseEntity<Profesores> createProfesor(@RequestBody Profesores profesor) {
        Profesores createdProfesor = profesorService.createOrUpdateProfesor(profesor);
        return new ResponseEntity<>(createdProfesor, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Profesores> updateProfesor(@PathVariable Long id, @RequestBody Profesores profesor) {
        Profesores updatedProfesor = profesorService.updateProfesor(id, profesor);
        return ResponseEntity.ok(updatedProfesor);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Profesores> partialUpdateProfesor(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Profesores updatedProfesor = profesorService.partialUpdateProfesor(id, updates);
        return ResponseEntity.ok(updatedProfesor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfesor(@PathVariable Long id) {
        profesorService.deleteProfesor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
