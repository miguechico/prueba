package com.example.api_crud.servicios;

import java.util.List;

import com.example.api_crud.modelos.Evento;

public interface IEventoServicio {

	public List<Evento> obtenerTodo();
	
	public Evento guardar(Evento evento);
	
	public Evento obtenerPorId(long PK_ID_EVENTO);
	
	public void eliminar(long PK_ID_EVENTO);
}
