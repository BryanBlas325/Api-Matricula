package com.cibertec.edu.pe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.edu.pe.models.Alumno;

public interface IAlumnoRepository extends JpaRepository<Alumno, Integer> {
	
}
