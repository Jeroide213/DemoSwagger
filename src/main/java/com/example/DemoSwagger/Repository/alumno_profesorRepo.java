package com.example.DemoSwagger.Repository;

import com.example.DemoSwagger.Model.alumno_profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface alumno_profesorRepo extends JpaRepository<alumno_profesor, Long> {
}