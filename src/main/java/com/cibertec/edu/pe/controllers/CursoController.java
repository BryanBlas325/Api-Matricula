package com.cibertec.edu.pe.controllers;

import com.cibertec.edu.pe.models.Curso;
import com.cibertec.edu.pe.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> getAllCursos() {
        return cursoService.getAllCursos();
    }

    @GetMapping("/{id}")
    public Optional<Curso> getCursoById(@PathVariable int id) {
        return cursoService.getCursoById(id);
    }

    @PostMapping
    public Curso saveCurso(@RequestBody Curso curso) {
        return cursoService.saveCurso(curso);
    }

    @DeleteMapping("/{id}")
    public void deleteCurso(@PathVariable int id) {
        cursoService.deleteCurso(id);
    }
}
