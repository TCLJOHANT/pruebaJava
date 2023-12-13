package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "docentes") 
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoDocumento;
    private String numeroDocumento;
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    private String ultimoGradoEscolaridad;
    private String gradoResponsable;
    private String email;
    private String telefonoFijo;
    private String celular;

    // Relación uno a muchos con Matricula
    @OneToMany(mappedBy = "docente")
    private List<Matricula> matriculas;

    // Relación uno a muchos con Asignatura
    @OneToMany(mappedBy = "docente")
    private List<Asignatura> asignaturas;

    // Getter y setter para id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter y setter para tipoDocumento
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    // Getter y setter para numeroDocumento
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    // Getter y setter para nombres
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    // Getter y setter para apellidos
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    // Getter y setter para fechaNacimiento
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getter y setter para ultimoGradoEscolaridad
    public String getUltimoGradoEscolaridad() {
        return ultimoGradoEscolaridad;
    }

    public void setUltimoGradoEscolaridad(String ultimoGradoEscolaridad) {
        this.ultimoGradoEscolaridad = ultimoGradoEscolaridad;
    }

    // Getter y setter para gradoResponsable
    public String getGradoResponsable() {
        return gradoResponsable;
    }

    public void setGradoResponsable(String gradoResponsable) {
        this.gradoResponsable = gradoResponsable;
    }

    // Getter y setter para email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter y setter para telefonoFijo
    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    // Getter y setter para celular
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    // Getter y setter para matriculas
    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    // Getter y setter para asignaturas
    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    // Constructor vacío
    public Docente() {
    }

    // Otro constructor con parámetros
    public Docente(String tipoDocumento, String numeroDocumento, String nombres, String apellidos, String fechaNacimiento,
                   String ultimoGradoEscolaridad, String gradoResponsable, String email, String telefonoFijo, String celular) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.ultimoGradoEscolaridad = ultimoGradoEscolaridad;
        this.gradoResponsable = gradoResponsable;
        this.email = email;
        this.telefonoFijo = telefonoFijo;
        this.celular = celular;
    }
}
