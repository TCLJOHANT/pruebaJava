package com.example.demo.model;
import jakarta.persistence.*;
@Entity
@Table(name = "cursos") 
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCurso;
}
