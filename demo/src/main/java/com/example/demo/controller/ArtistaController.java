package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Artista;
import com.example.demo.model.ArtistaRepository;

@RestController
@RequestMapping("/api/artistas/")
public class ArtistaController {
    private final ArtistaRepository artistaRepository;
  
    public ArtistaController(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }
    
    @GetMapping
        public ResponseEntity<List<Artista>> obtenerArtistas() {
            try {
                List<Artista> artistas = artistaRepository.findAll();
                return ResponseEntity.ok(artistas);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
    @GetMapping("/{id}")
        public ResponseEntity<Artista> obtenerArtistaPorId(@PathVariable Long id) {
            try {
                Optional<Artista> artista = artistaRepository.findById(id);
                if (artista.isPresent()) {
                    return ResponseEntity.ok(artista.get());
                } else {
                        return ResponseEntity.notFound().build();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
       

    @PostMapping
        public ResponseEntity<Void> crearArtista(@RequestBody Artista artista) {
            try {
                artistaRepository.save(artista);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        
    @PutMapping
        public ResponseEntity<Void> actualizarArtista(@RequestBody Artista artista) {
            try {
                artistaRepository.save(artista);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }   
    @DeleteMapping("/{id}")
        public ResponseEntity<Void> eliminarArtista(@PathVariable("id") Long id) {
        try {
            artistaRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.noContent().build();
        }
    }