package com.example.DemoSwagger.Repository;

import com.example.DemoSwagger.Model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MateriaRepo extends JpaRepository<Materia,Long> {
    List<Materia> findByNombreContainingIgnoreCase(String nombre);
}
