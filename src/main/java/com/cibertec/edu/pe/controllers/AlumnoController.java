package com.cibertec.edu.pe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cibertec.edu.pe.models.Alumno;
import com.cibertec.edu.pe.repositories.IAlumnoRepository;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
	@Autowired
	private IAlumnoRepository repository;
	
	@GetMapping
	public List<Alumno>listar(){
		return repository.findAll();
	}
	@PostMapping
	public Alumno insertar(@RequestBody Alumno a) {
		Alumno data = repository.save(a);
		return data;
	}
	@PutMapping
	public Alumno modificar(@RequestBody Alumno a) {
		Alumno data;
		data = repository.save(a);
		return data;
	}
	@GetMapping(value="/{id}")
	public Alumno buscar(@PathVariable("id") int id) {
		Alumno data = repository.findById(id).get();
		return data;
	}
	@DeleteMapping(value = "/{id}")
	public void suprimir(@PathVariable("id") int id) {
		repository.deleteById(id);
	}
}
