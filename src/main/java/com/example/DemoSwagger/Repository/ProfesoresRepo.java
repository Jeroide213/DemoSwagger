package com.example.DemoSwagger.Repository;

import com.example.DemoSwagger.Model.Profesores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesoresRepo extends JpaRepository<Profesores, Long> {
    List<Profesores> findByNombreContainingIgnoreCase(String nombre);
}
