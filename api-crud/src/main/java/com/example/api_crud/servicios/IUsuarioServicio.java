package com.example.api_crud.servicios;

import java.util.List;

import com.example.api_crud.modelos.Usuario;

public interface IUsuarioServicio {
	
	public List<Usuario> obtenerTodo();
	
	public Usuario guardar(Usuario usuario);
	
	public Usuario obtenerPorId(long PK_ID_USUARIO);
	
	public void eliminar(long PK_ID_USUARIO);
	
}
