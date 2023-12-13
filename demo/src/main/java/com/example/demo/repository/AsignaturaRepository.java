package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Asignatura;

public interface AsignaturaRepository  extends JpaRepository<Asignatura, Long> {
    
}
