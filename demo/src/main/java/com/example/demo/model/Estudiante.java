package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "estudiantes") 
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoDocumento;
    private String numeroDocumento;
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    private String gradoMatriculado;
    private String ciudadResidencia;
    private String direccionResidencia;
    private String email;
    private String telefonoFijo;
    private String celular;
    private String nombreAcudiente;

    // Relación uno a muchos con Matricula
    @OneToMany(mappedBy = "estudiante")
    private List<Matricula> matriculas;

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

    // Getter y setter para gradoMatriculado
    public String getGradoMatriculado() {
        return gradoMatriculado;
    }

    public void setGradoMatriculado(String gradoMatriculado) {
        this.gradoMatriculado = gradoMatriculado;
    }

    // Getter y setter para ciudadResidencia
    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    // Getter y setter para direccionResidencia
    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
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

    // Getter y setter para nombreAcudiente
    public String getNombreAcudiente() {
        return nombreAcudiente;
    }

    public void setNombreAcudiente(String nombreAcudiente) {
        this.nombreAcudiente = nombreAcudiente;
    }

    // Getter y setter para matriculas
    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    // Constructor vacío
    public Estudiante() {
    }

    // Otro constructor con parámetros
    public Estudiante(String tipoDocumento, String numeroDocumento, String nombres, String apellidos, String fechaNacimiento,
                      String gradoMatriculado, String ciudadResidencia, String direccionResidencia, String email,
                      String telefonoFijo, String celular, String nombreAcudiente) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.gradoMatriculado = gradoMatriculado;
        this.ciudadResidencia = ciudadResidencia;
        this.direccionResidencia = direccionResidencia;
        this.email = email;
        this.telefonoFijo = telefonoFijo;
        this.celular = celular;
        this.nombreAcudiente = nombreAcudiente;
    }
}
