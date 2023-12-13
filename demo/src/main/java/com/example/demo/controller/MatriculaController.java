package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Matricula;
import com.example.demo.repository.MatriculaRepository;

@RestController
@RequestMapping("/api/matriculas/")
public class MatriculaController {
    private final MatriculaRepository matriculaRepository;

    public MatriculaController(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> obtenerMatriculas() {
        try {
            List<Matricula> matriculas = matriculaRepository.findAll();
            return ResponseEntity.ok(matriculas);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> obtenerMatriculaPorId(@PathVariable Long id) {
        try {
            Optional<Matricula> matricula = matriculaRepository.findById(id);
            return matricula.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> crearMatricula(@RequestBody Matricula matricula) {
        try {
            matriculaRepository.save(matricula);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarMatricula(@PathVariable Long id, @RequestBody Matricula matricula) {
        try {
            if (matriculaRepository.existsById(id)) {
                matricula.setId(id);
                matriculaRepository.save(matricula);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMatricula(@PathVariable Long id) {
        try {
            matriculaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
