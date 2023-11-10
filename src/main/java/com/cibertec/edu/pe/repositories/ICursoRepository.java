package com.cibertec.edu.pe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.edu.pe.models.Curso;

public interface ICursoRepository extends JpaRepository<Curso, Integer> {

}
