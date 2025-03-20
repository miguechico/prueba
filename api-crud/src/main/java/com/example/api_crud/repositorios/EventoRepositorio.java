package com.example.api_crud.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_crud.modelos.Evento;


@Repository
public interface EventoRepositorio extends JpaRepository<Evento, Long>{

}
