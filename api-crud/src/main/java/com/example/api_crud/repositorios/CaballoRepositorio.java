package com.example.api_crud.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_crud.modelos.Caballo;

@Repository
public interface CaballoRepositorio extends JpaRepository<Caballo, Long>{

}
