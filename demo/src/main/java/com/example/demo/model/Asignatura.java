package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "asignaturas") 

public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreAsignatura;

    // Relación muchos a uno con Docente
    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;

    // Relación uno a muchos con Matricula
    @OneToMany(mappedBy = "asignatura")
    private List<Matricula> matriculas;

    // Getter y setter para id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    // Getter y setter para nombreAsignatura
    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    // Getter y setter para docente
    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    // Getter y setter para matriculas
    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    // Constructor vacío
    public Asignatura() {
    }

    // Otro constructor con parámetros
    public Asignatura(String nombreAsignatura, Docente docente) {
 
        this.nombreAsignatura = nombreAsignatura;
        this.docente = docente;
    }
}