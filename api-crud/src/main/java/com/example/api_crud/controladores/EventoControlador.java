package com.example.api_crud.controladores;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.api_crud.modelos.Evento;
import com.example.api_crud.servicios.EventoServicioImpl;

@RestController
@RequestMapping("/api/v1/eventos")
public class EventoControlador {

	@Autowired
	EventoServicioImpl eventoservicio;

	@GetMapping
	public List<Evento> obtenerEventos() {
		return eventoservicio.obtenerTodo();
	}

	@PostMapping
	public ResponseEntity<Evento> guardarEvento(@RequestBody Evento evento) {
		Evento nuevoEvento = eventoservicio.guardar(evento);
		return new ResponseEntity<>(nuevoEvento, HttpStatus.CREATED);
	}

	@GetMapping("/{PK_ID_EVENTO}")
	public ResponseEntity<Evento> obtenerEventoId(@PathVariable long PK_ID_EVENTO) {
		Evento evento = eventoservicio.obtenerPorId(PK_ID_EVENTO);
		return evento != null ? ResponseEntity.ok(evento) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{PK_ID_EVENTO}")
	public ResponseEntity<Evento> actualizar(@PathVariable long PK_ID_EVENTO, @RequestBody Evento evento) {

		Evento eventoExistente = eventoservicio.obtenerPorId(PK_ID_EVENTO);
		if (eventoExistente == null) {
			return ResponseEntity.notFound().build();
		}

		eventoExistente.setNOMBRE(evento.getNOMBRE());
		eventoExistente.setFECHA(evento.getFECHA());
		eventoExistente.setTIPO(evento.getTIPO());

		Evento eventoActualizado = eventoservicio.guardar(eventoExistente);
		return ResponseEntity.ok(eventoActualizado);
	}

	@DeleteMapping("/{PK_ID_EVENTO}")
	public ResponseEntity<HashMap<String, Boolean>> eliminarEvento(@PathVariable long PK_ID_EVENTO) {
		Evento evento = eventoservicio.obtenerPorId(PK_ID_EVENTO);
		if (evento == null) {
			return ResponseEntity.notFound().build();
		}

		eventoservicio.eliminar(PK_ID_EVENTO);
		HashMap<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminado", true);
		return ResponseEntity.ok(respuesta);
	}
}