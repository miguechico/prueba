package com.example.api_crud.controladores;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.api_crud.modelos.Usuario;
import com.example.api_crud.servicios.UsuarioServicioImpl;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioControlador {

	@Autowired
	UsuarioServicioImpl usuarioservicio;

	@GetMapping
	public List<Usuario> obtenerUsuarios() {
		return usuarioservicio.obtenerTodo();
	}

	@PostMapping
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
		Usuario nuevoUsuario = usuarioservicio.guardar(usuario);
		return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
	}

	@GetMapping("/{PK_ID_USUARIO}")
	public ResponseEntity<Usuario> obtenerUsuarioId(@PathVariable long PK_ID_USUARIO) {
		Usuario usuario = usuarioservicio.obtenerPorId(PK_ID_USUARIO);
		return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{PK_ID_USUARIO}")
	public ResponseEntity<Usuario> actualizar(@PathVariable long PK_ID_USUARIO, @RequestBody Usuario usuario) {

		Usuario usuarioExistente = usuarioservicio.obtenerPorId(PK_ID_USUARIO);
		if (usuarioExistente == null) {
			return ResponseEntity.notFound().build();
		}

		usuarioExistente.setNOMBRE_APELLIDO(usuario.getNOMBRE_APELLIDO());
		usuarioExistente.setUSERNAME(usuario.getUSERNAME());
		usuarioExistente.setNACIMIENTO(usuario.getNACIMIENTO());
		usuarioExistente.setPASSWORD(usuario.getPASSWORD());
		usuarioExistente.setEMAIL(usuario.getEMAIL());

		Usuario usuarioActualizado = usuarioservicio.guardar(usuarioExistente);
		return ResponseEntity.ok(usuarioActualizado);
	}

	@DeleteMapping("/{PK_ID_USUARIO}")
	public ResponseEntity<HashMap<String, Boolean>> eliminarUsuario(@PathVariable long PK_ID_USUARIO) {
		Usuario usuario = usuarioservicio.obtenerPorId(PK_ID_USUARIO);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}

		usuarioservicio.eliminar(PK_ID_USUARIO);
		HashMap<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminado", true);
		return ResponseEntity.ok(respuesta);
	}
}