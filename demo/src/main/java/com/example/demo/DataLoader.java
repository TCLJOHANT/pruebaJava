package com.example.demo;

import com.example.demo.model.Asignatura;
import com.example.demo.model.Docente;
import com.example.demo.model.Estudiante;
import com.example.demo.model.Matricula;
import com.example.demo.repository.AsignaturaRepository;
import com.example.demo.repository.DocenteRepository;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.MatriculaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;


@Component
public class DataLoader implements CommandLineRunner {

    private final EstudianteRepository estudianteRepository;
    private final DocenteRepository docenteRepository;
     private final AsignaturaRepository asignaturaRepository;
     private final MatriculaRepository matriculaRepository;

    @Autowired
    public DataLoader(MatriculaRepository matriculaRepository ,AsignaturaRepository asignaturaRepository , EstudianteRepository estudianteRepository,DocenteRepository docenteRepository) {
        this.estudianteRepository = estudianteRepository;
        this.docenteRepository = docenteRepository;
        this.asignaturaRepository = asignaturaRepository;
          this.matriculaRepository = matriculaRepository;
    }

    @Override
    public void run(String... args) {
        dataEstudiantesJSON();
        dataDocentesJSON();
        // dataAsignaturasJSON();
        // dataMatriculasJSON();
    }

    private void dataEstudiantesJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //Leer el archivo JSON desde el directorio resources
            ClassPathResource resource = new ClassPathResource("pobladoDB/estudiantes.json");
            Estudiante[] estudiantes = objectMapper.readValue(resource.getInputStream(), Estudiante[].class);
            estudianteRepository.saveAll(Arrays.asList(estudiantes));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     private void dataDocentesJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //Leer el archivo JSON desde el directorio resources
            ClassPathResource resource = new ClassPathResource("pobladoDB/docentes.json");
            Docente[] docentes = objectMapper.readValue(resource.getInputStream(), Docente[].class);
            docenteRepository.saveAll(Arrays.asList(docentes));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void dataAsignaturasJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //Leer el archivo JSON desde el directorio resources
            ClassPathResource resource = new ClassPathResource("pobladoDB/asignaturas.json");
            Asignatura[] asignaturas = objectMapper.readValue(resource.getInputStream(), Asignatura[].class);
            asignaturaRepository.saveAll(Arrays.asList(asignaturas));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     private void dataMatriculasJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //Leer el archivo JSON desde el directorio resources
            ClassPathResource resource = new ClassPathResource("pobladoDB/matriculas.json");
            Matricula[] matriculas = objectMapper.readValue(resource.getInputStream(), Matricula[].class);
            matriculaRepository.saveAll(Arrays.asList(matriculas));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
