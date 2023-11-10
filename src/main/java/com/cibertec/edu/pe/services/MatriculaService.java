package com.cibertec.edu.pe.services;

import com.cibertec.edu.pe.models.Matricula;
import com.cibertec.edu.pe.repositories.IMatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {

    @Autowired
    private IMatriculaRepository matriculaRepository;

    public List<Matricula> getAllMatriculas() {
        return matriculaRepository.findAll();
    }

    public Optional<Matricula> getMatriculaById(int id) {
        return matriculaRepository.findById(id);
    }

    public Matricula saveMatricula(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    public void deleteMatricula(int id) {
        matriculaRepository.deleteById(id);
    }
}
