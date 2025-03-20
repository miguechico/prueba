package com.example.api_crud.controladores;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.api_crud.modelos.Caballo;
import com.example.api_crud.servicios.CaballoServicioImpl;

@RestController
@RequestMapping("/api/v1/caballos")
public class CaballoControlador {

	@Autowired
	CaballoServicioImpl caballoservicio;

	@GetMapping
	public List<Caballo> obtenerCaballos() {
		return caballoservicio.obtenerTodo();
	}

	@PostMapping
	public ResponseEntity<Caballo> guardarCaballo(@RequestBody Caballo caballo) {
		Caballo nuevoCaballo = caballoservicio.guardar(caballo);
		return new ResponseEntity<>(nuevoCaballo, HttpStatus.CREATED);
	}

	@GetMapping("/{PK_ID_CABALLO}")
	public ResponseEntity<Caballo> obtenerCaballoId(@PathVariable long PK_ID_CABALLO) {
		Caballo caballo = caballoservicio.obtenerPorId(PK_ID_CABALLO);
		return caballo != null ? ResponseEntity.ok(caballo) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{PK_ID_CABALLO}")
	public ResponseEntity<Caballo> actualizar(@PathVariable long PK_ID_CABALLO, @RequestBody Caballo caballo) {

		Caballo caballoExistente = caballoservicio.obtenerPorId(PK_ID_CABALLO);
		if (caballoExistente == null) {
			return ResponseEntity.notFound().build();
		}

		caballoExistente.setNOMBRE(caballo.getNOMBRE());
		caballoExistente.setRAZA(caballo.getRAZA());
		caballoExistente.setRENDIMIENTO(caballo.getRENDIMIENTO());
		caballoExistente.setFK_ID_USUARIO(caballo.getFK_ID_USUARIO());

		Caballo caballoActualizado = caballoservicio.guardar(caballoExistente);
		return ResponseEntity.ok(caballoActualizado);
	}

	@DeleteMapping("/{PK_ID_CABALLO}")
	public ResponseEntity<HashMap<String, Boolean>> eliminarCaballo(@PathVariable long PK_ID_CABALLO) {
		Caballo caballo = caballoservicio.obtenerPorId(PK_ID_CABALLO);
		if (caballo == null) {
			return ResponseEntity.notFound().build();
		}

		caballoservicio.eliminar(PK_ID_CABALLO);
		HashMap<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminado", true);
		return ResponseEntity.ok(respuesta);
	}
}