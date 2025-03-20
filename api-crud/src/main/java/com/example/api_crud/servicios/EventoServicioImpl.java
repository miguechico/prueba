package com.example.api_crud.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_crud.modelos.Evento;
import com.example.api_crud.repositorios.EventoRepositorio;

@Service
public class EventoServicioImpl implements IEventoServicio{

	@Autowired 
	EventoRepositorio eventorepositorio;
	
	@Override
	public List<Evento> obtenerTodo() {
		return eventorepositorio.findAll();
	}

	@Override
	public Evento guardar(Evento evento) {
		return eventorepositorio.save(evento);
	}

	@Override
	public Evento obtenerPorId(long PK_ID_EVENTO) {
		return eventorepositorio.findById(PK_ID_EVENTO).orElse(null);
	}

	@Override
	public void eliminar(long PK_ID_EVENTO) {
		eventorepositorio.deleteById(PK_ID_EVENTO);
		
	}

}
