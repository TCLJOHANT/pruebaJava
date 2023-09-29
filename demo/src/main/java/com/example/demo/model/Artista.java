 package com.example.demo.model;
 import jakarta.persistence.Entity;
 import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 import jakarta.persistence.Table;
 @Entity
 @Table(name = "artistas")
 public class Artista {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String nombre;
     private String genero;
     private String descripcion;
    // Constructor vacío necesario para JPA
    public Artista() {}
     public Artista(Long id, String nombre, String genero, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.descripcion = descripcion;

     }
     // Getters y setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getNombre() {return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre;}
    public String getGenero() {return genero;}
    public void setGenero(String genero){this.genero = genero;}
    public String getDescripcion() { return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
 }


