package com.example.api_crud.controladores;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_crud.modelos.Usuario;
import com.example.api_crud.servicios.UsuarioServicioImpl;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioControlador {
	
	@Autowired
	UsuarioServicioImpl usuarioservicio;
	
	@GetMapping("/usuarios")
	public List<Usuario> obtenerUsuarios(){
		return usuarioservicio.obtenerTodo();
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
		Usuario nuevo_usuario = usuarioservicio.guardar(usuario);
		return new ResponseEntity<>(nuevo_usuario, HttpStatus.CREATED);
	}
	
	@GetMapping("/usuario/{PK_ID_USUARIO}")
	public ResponseEntity<Usuario> obtenerUsuarioId(@PathVariable long PK_ID_USUARIO){
		Usuario usuarioPorId = usuarioservicio.obtenerPorId(PK_ID_USUARIO);
		
		return ResponseEntity.ok(usuarioPorId);
	}
	
	@PutMapping("/usuario/{PK_ID_USUARIO}")
	public ResponseEntity<Usuario> actualizar(@PathVariable long PK_ID_USUARIO,@RequestBody Usuario usuario){
		Usuario usuarioPorId = usuarioservicio.obtenerPorId(PK_ID_USUARIO);
		usuarioPorId.setNOMBRE_APELLIDO(usuario.getNOMBRE_APELLIDO());
		usuarioPorId.setUSERNAME(usuario.getUSERNAME());
		usuarioPorId.setNACIMIENTO(usuario.getNACIMIENTO());
		usuarioPorId.setPASSWORD(usuario.getPASSWORD());
		usuarioPorId.setEMAIL(usuario.getEMAIL());
		
		Usuario usuario_actualizado = usuarioservicio.guardar(usuarioPorId);
		return new ResponseEntity<>(usuario_actualizado, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/usuario/{PK_ID_USUARIO}")
	public ResponseEntity<HashMap<String, Boolean>> eliminarUsuario(@PathVariable long PK_ID_USUARIO) {
		this.usuarioservicio.eliminar(PK_ID_USUARIO);
		
		HashMap<String, Boolean> estadoUsuarioEliminado = new HashMap();
		estadoUsuarioEliminado.put("eliminado", true);
		return ResponseEntity.ok(estadoUsuarioEliminado);
	}

}
