package com.cibertec.edu.pe.controllers;

import com.cibertec.edu.pe.models.Matricula;
import com.cibertec.edu.pe.services.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping
    public List<Matricula> getAllMatriculas() {
        return matriculaService.getAllMatriculas();
    }

    @GetMapping("/{id}")
    public Optional<Matricula> getMatriculaById(@PathVariable int id) {
        return matriculaService.getMatriculaById(id);
    }

    @PostMapping
    public Matricula saveMatricula(@RequestBody Matricula matricula) {
        return matriculaService.saveMatricula(matricula);
    }

    @DeleteMapping("/{id}")
    public void deleteMatricula(@PathVariable int id) {
        matriculaService.deleteMatricula(id);
    }
}
