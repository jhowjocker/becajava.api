package br.casadeshow.app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.casadeshow.app.model.*;
import br.casadeshow.app.servicel.*;

@RestController
@RequestMapping("/Musicos")
public class MusicoController {
	
		public MusicoService _service;
		
		@Autowired
		public MusicoController(MusicoService service) {
			_service = service;
		}

		@PostMapping
		public ResponseEntity inserir(@RequestBody Musico musico) {
			_service.inserir(musico);
			return ResponseEntity.status(HttpStatus.CREATED).body("Musico Inserido com sucesso!");
		}
		
		@GetMapping
		public ResponseEntity listar() {
			Iterable<Musico> musico= _service.listar();
		return ResponseEntity.status(HttpStatus.OK).body(musico);
		}
		
		
}
