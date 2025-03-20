package com.example.api_crud.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_crud.modelos.Caballo;
import com.example.api_crud.repositorios.CaballoRepositorio;

@Service
public class CaballoServicioImpl implements ICaballoServicio{
	
	@Autowired
	CaballoRepositorio caballorepositorio;

	@Override
	public List<Caballo> obtenerTodo() {
		return caballorepositorio.findAll();
	}

	@Override
	public Caballo guardar(Caballo caballo) {
		return caballorepositorio.save(caballo);
	}

	@Override
	public Caballo obtenerPorId(long PK_ID_CABALLO) {
		return caballorepositorio.findById(PK_ID_CABALLO).orElse(null);
	}

	@Override
	public void eliminar(long PK_ID_CABALLO) {
		caballorepositorio.deleteById(PK_ID_CABALLO);
		
	}

}
