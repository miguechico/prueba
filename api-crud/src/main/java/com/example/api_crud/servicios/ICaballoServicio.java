package com.example.api_crud.servicios;

import java.util.List;

import com.example.api_crud.modelos.Caballo;


public interface ICaballoServicio {

public List<Caballo> obtenerTodo();
	
	public Caballo guardar(Caballo caballo);
	
	public Caballo obtenerPorId(long PK_ID_CABALLO);
	
	public void eliminar(long PK_ID_CABALLO);
}
