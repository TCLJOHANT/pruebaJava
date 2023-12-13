package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "matriculas")
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String añoLectivo;

    // Relación muchos a uno con Estudiante
    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    // Relación muchos a uno con Docente
    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;

    // Relación muchos a uno con Asignatura
    @ManyToOne
    @JoinColumn(name = "asignatura_id")
    private Asignatura asignatura;

    // Getter y setter para id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter y setter para añoLectivo
    public String getAñoLectivo() {
        return añoLectivo;
    }

    public void setAñoLectivo(String añoLectivo) {
        this.añoLectivo = añoLectivo;
    }

    // Getter y setter para estudiante
    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    // Getter y setter para docente
    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    // Getter y setter para asignatura
    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    // Constructor vacío
    public Matricula() {
    }

    // Otro constructor con parámetros
    public Matricula(String añoLectivo, Estudiante estudiante, Docente docente, Asignatura asignatura) {
        this.añoLectivo = añoLectivo;
        this.estudiante = estudiante;
        this.docente = docente;
        this.asignatura = asignatura;
    }
}
