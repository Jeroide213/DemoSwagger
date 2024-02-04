package com.example.DemoSwagger.Repository;

import com.example.DemoSwagger.Model.Alumnos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnosRepo extends JpaRepository<Alumnos, Long> {
    List<Alumnos> findByNombreContainingIgnoreCase(String nombre);
}
