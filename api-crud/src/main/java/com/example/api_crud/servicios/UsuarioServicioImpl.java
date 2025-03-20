package com.example.api_crud.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_crud.modelos.Usuario;
import com.example.api_crud.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio{
	
	@Autowired
	UsuarioRepositorio usuariorepositorio;

	@Override
	public List<Usuario> obtenerTodo() {
		return usuariorepositorio.findAll();
	}

	@Override
	public Usuario guardar(Usuario usuario) {
		return usuariorepositorio.save(usuario);
	}

	@Override
	public Usuario obtenerPorId(long PK_ID_USUARIO) {
		return usuariorepositorio.findById(PK_ID_USUARIO).orElse(null);
	}

	@Override
	public void eliminar(long PK_ID_USUARIO) {
		usuariorepositorio.deleteById(PK_ID_USUARIO);
		
	}

}
