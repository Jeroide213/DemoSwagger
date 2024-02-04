package com.example.DemoSwagger.Repository;

import com.example.DemoSwagger.Model.Profesor_Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Profesor_MateriaRepo extends JpaRepository<Profesor_Materia,Long> {
}
