package com.example.DemoSwagger.Controller;

import com.example.DemoSwagger.Exception.EntityNotFoundException;
import com.example.DemoSwagger.Model.Alumnos;
import com.example.DemoSwagger.Service.AlumnosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Alumnos")
public class AlumnosController {
        @Autowired
        private AlumnosService alumnoService;

        @Operation(summary = "Mostrar todos los alumnos")
        @GetMapping
        public ResponseEntity<List<Alumnos>> getAllAlumnos() {
            List<Alumnos> alumnos = alumnoService.getAllAlumnos();
            return new ResponseEntity<>(alumnos, HttpStatus.OK);
        }

        @Operation(summary = "Encontrar a un alumno por ID")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Alumno encontrado con exito!", content = {
                        @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Alumnos.class))
                }),
                @ApiResponse(responseCode = "500", description = "ID invalido!", content = @Content)
        })
        @GetMapping("/{id}")
        public ResponseEntity<Alumnos> getAlumnoById(@Parameter(description = "ID del alumno a buscar", example = "1")@PathVariable Long id) {
            Alumnos alumno = alumnoService.getAlumnoById(id);
            if (alumno != null) {
                return new ResponseEntity<>(alumno, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    @Operation(summary = "Filtrar a los alumnos por nombre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alumno encontrado con exito!", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Alumnos.class))
            })
    })
    @GetMapping("/buscarPorNombre")
    public ResponseEntity<List<Alumnos>> buscarAlumnosPorNombre(@Parameter(description = "Nombre de el o los alumnos a buscar", example = "Pepito")@RequestParam String nombre) {
        List<Alumnos> alumnos = alumnoService.findByNombre(nombre);
        return ResponseEntity.ok(alumnos);
    }

    @Operation(summary = "Registrar a un alumno")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alumno registrado con exito!", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Alumnos.class))
            }),
            @ApiResponse(responseCode = "500", description = "Atributos no validos!", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Alumnos> createAlumno(@RequestBody Alumnos alumno) {
            Alumnos createdAlumno = alumnoService.createOrUpdateAlumno(alumno);
            return new ResponseEntity<>(createdAlumno, HttpStatus.CREATED);
        }
    @Operation(summary = "Actualizar a un alumno")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alumno actualizado con exito!", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Alumnos.class))
            }),
            @ApiResponse(responseCode = "500", description = "ID o atributos no validos!", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<Alumnos> updateAlumno(@Parameter(description = "ID del alumno a actualizar", example = "5")@PathVariable Long id, @RequestBody Alumnos alumno) {
        Alumnos updatedAlumno;
        try {
            updatedAlumno = alumnoService.updateAlumno(id, alumno);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedAlumno);
    }

    @Operation(summary = "Actualizar a un alumno por partes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Parametro actualizado con exito!", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Alumnos.class))
            }),
            @ApiResponse(responseCode = "500", description = "ID no valida!", content = @Content)
    })
    @PatchMapping("/{id}")
    public ResponseEntity<Alumnos> partialUpdateAlumno(@Parameter(description = "ID del alumno a actualizar", example = "3")@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Alumnos updatedAlumno;
        try {
            updatedAlumno = alumnoService.partialUpdateAlumno(id, updates);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedAlumno);
    }
    @Operation(summary = "Eliminar a un alumno por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alumno eliminado con exito!", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Alumnos.class))
            }),
            @ApiResponse(responseCode = "500", description = "ID no valida!", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlumno(@Parameter(description = "ID del alumno a eliminar", example = "69")@PathVariable Long id) {
            alumnoService.deleteAlumno(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
}