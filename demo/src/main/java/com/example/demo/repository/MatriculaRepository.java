package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Matricula;

public interface MatriculaRepository  extends JpaRepository<Matricula, Long> {
    
}
