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

import com.example.api_crud.modelos.Caballo;
import com.example.api_crud.servicios.CaballoServicioImpl;



@RestController
@RequestMapping("/api/v1/caballos")
public class CaballoControlador {
	
	@Autowired
	CaballoServicioImpl caballoservicio;
	
	@GetMapping("/caballos")
	public List<Caballo> obtenerCaballos(){
		return caballoservicio.obtenerTodo();
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Caballo> guardarCaballo(@RequestBody Caballo caballo){
		Caballo nuevo_caballo = caballoservicio.guardar(caballo);
		return new ResponseEntity<>(nuevo_caballo, HttpStatus.CREATED);
	}
	
	@GetMapping("/caballo/{PK_ID_CABALLO}")
	public ResponseEntity<Caballo> obtenerCaballoId(@PathVariable long PK_ID_CABALLO){
		Caballo caballoPorId = caballoservicio.obtenerPorId(PK_ID_CABALLO);
		
		return ResponseEntity.ok(caballoPorId);
	}
	
	@PutMapping("/caballo/{PK_ID_CABALLO}")
	public ResponseEntity<Caballo> actualizar(@PathVariable long PK_ID_CABALLO,@RequestBody Caballo caballo){
		Caballo caballoPorId = caballoservicio.obtenerPorId(PK_ID_CABALLO);
		caballoPorId.setNOMBRE(caballo.getNOMBRE());
		caballoPorId.setRAZA(caballo.getRAZA());
		caballoPorId.setRENDIMIENTO(caballo.getRENDIMIENTO());
		caballoPorId.setFK_ID_USUARIO(caballo.getFK_ID_USUARIO());
		
		
		Caballo caballo_actualizado = caballoservicio.guardar(caballoPorId);
		return new ResponseEntity<>(caballo_actualizado, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/caballo/{PK_ID_CABALLO}")
	public ResponseEntity<HashMap<String, Boolean>> eliminarCaballo(@PathVariable long PK_ID_CABALLO) {
		this.caballoservicio.eliminar(PK_ID_CABALLO);
		
		HashMap<String, Boolean> estadoCaballoEliminado = new HashMap();
		estadoCaballoEliminado.put("eliminado", true);
		return ResponseEntity.ok(estadoCaballoEliminado);
	}

}
