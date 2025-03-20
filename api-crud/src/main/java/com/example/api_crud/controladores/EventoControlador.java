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

import com.example.api_crud.modelos.Evento;
import com.example.api_crud.servicios.EventoServicioImpl;

@RestController
@RequestMapping("/api/v1/eventos")
public class EventoControlador {

	@Autowired
	EventoServicioImpl eventoservicio;
	
	@GetMapping("/eventos")
	public List<Evento> obtenerEventos(){
		return eventoservicio.obtenerTodo();
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Evento> guardarEvento(@RequestBody Evento evento){
		Evento nuevo_evento = eventoservicio.guardar(evento);
		return new ResponseEntity<>(nuevo_evento, HttpStatus.CREATED);
	}
	
	@GetMapping("/evento/{PK_ID_EVENTO}")
	public ResponseEntity<Evento> obtenerEventoId(@PathVariable long PK_ID_EVENTO){
		Evento eventoPorId = eventoservicio.obtenerPorId(PK_ID_EVENTO);
		
		return ResponseEntity.ok(eventoPorId);
	}
	
	@PutMapping("/evento/{PK_ID_EVENTO}")
	public ResponseEntity<Evento> actualizar(@PathVariable long PK_ID_EVENTO,@RequestBody Evento evento){
		Evento eventoPorId = eventoservicio.obtenerPorId(PK_ID_EVENTO);
		eventoPorId.setNOMBRE(evento.getNOMBRE());
		eventoPorId.setFECHA(evento.getFECHA());
		eventoPorId.setTIPO(evento.getTIPO());
		
		
		Evento evento_actualizado = eventoservicio.guardar(eventoPorId);
		return new ResponseEntity<>(evento_actualizado, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/evento/{PK_ID_EVENTO}")
	public ResponseEntity<HashMap<String, Boolean>> eliminarEvento(@PathVariable long PK_ID_EVENTO) {
		this.eventoservicio.eliminar(PK_ID_EVENTO);
		
		HashMap<String, Boolean> estadoEventoEliminado = new HashMap();
		estadoEventoEliminado.put("eliminado", true);
		return ResponseEntity.ok(estadoEventoEliminado);
	}

	
}
