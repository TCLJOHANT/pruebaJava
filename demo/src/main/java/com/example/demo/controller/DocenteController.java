package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Docente;
import com.example.demo.repository.DocenteRepository;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/docentes/")
public class DocenteController {

    private final DocenteRepository docenteRepository;

    public DocenteController(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    @GetMapping
    public ResponseEntity<List<Docente>> obtenerDocentes() {
        try {
            List<Docente> docentes = docenteRepository.findAll();
            return ResponseEntity.ok(docentes);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Docente> obtenerDocentePorId(@PathVariable Long id) {
        try {
            Optional<Docente> docente= docenteRepository.findById(id);
            if (docente.isPresent()) {
                return ResponseEntity.ok(docente.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> crearDocente(@RequestBody Docente docente) {
        try {
            docenteRepository.save(docente);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarDocente(@PathVariable Long id, @RequestBody Docente docente) {
        try {
            docente.setId(id);
            docenteRepository.save(docente);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDocente(@PathVariable Long id) {
        try {
            docenteRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.noContent().build();
    }
}
