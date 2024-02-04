package com.example.DemoSwagger.Controller;

import com.example.DemoSwagger.Exception.EntityNotFoundException;
import com.example.DemoSwagger.Model.alumno_profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.DemoSwagger.Service.alumnos_profesorService;
import java.util.List;

@RestController
@RequestMapping("/alumno_profesor")
public class alumno_profesorController {
    @Autowired
    private alumnos_profesorService AlumnoProfesorService;

    @GetMapping
    public List<alumno_profesor> getAllAlumnoProfesors() {
        return AlumnoProfesorService.getAllAlumnoProfesors();
    }

    @GetMapping("/{id}")
    public alumno_profesor getAlumnoProfesorById(@PathVariable Long id) {
        return AlumnoProfesorService.getAlumnoProfesorById(id)
                .orElseThrow(() -> new EntityNotFoundException("Materia with id " + id + " not found"));
    }

    @PostMapping
    public alumno_profesor createAlumnoProfesor(@RequestBody alumno_profesor alumnoProfesor) {
        return AlumnoProfesorService.createAlumnoProfesor(alumnoProfesor);
    }

    @PutMapping("/{id}")
    public alumno_profesor updateAlumnoProfesor(@PathVariable Long id, @RequestBody alumno_profesor alumnoProfesor) {
        return AlumnoProfesorService.updateAlumnoProfesor(id, alumnoProfesor);
    }

    @DeleteMapping("/{id}")
    public void deleteAlumnoProfesor(@PathVariable Long id) {
        AlumnoProfesorService.deleteAlumnoProfesor(id);
    }
}