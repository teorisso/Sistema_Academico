package com.example.sistema_academico.repository;

import com.example.sistema_academico.entity.Comision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComisionRepository extends JpaRepository<Comision, Integer> {
}