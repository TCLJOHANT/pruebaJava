package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Asignatura;
import com.example.demo.repository.AsignaturaRepository;



import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asignaturas/")
public class AsignaturaController {

    private final AsignaturaRepository asignaturaRepository;

    public AsignaturaController(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }

    @GetMapping
    public ResponseEntity<List<Asignatura>> obtenerAsignaturas() {
        try {
            List<Asignatura> asignaturas = asignaturaRepository.findAll();
            return ResponseEntity.ok(asignaturas);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> obtenerAsignaturaPorId(@PathVariable Long id) {
        try {
            Optional<Asignatura> asignatura= asignaturaRepository.findById(id);
            if (asignatura.isPresent()) {
                return ResponseEntity.ok(asignatura.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> crearAsignatura(@RequestBody Asignatura asignatura) {
        try {
            asignaturaRepository.save(asignatura);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarAsignatura(@PathVariable Long id, @RequestBody Asignatura asignatura) {
        try {
            asignatura.setId(id);
            asignaturaRepository.save(asignatura);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAsignatura(@PathVariable Long id) {
        try {
            asignaturaRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.noContent().build();
    }
}
