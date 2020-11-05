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
@RequestMapping("/bandas")
public class BandaController {
	
		public BandaService _service;
		
		@Autowired
		public BandaController(BandaService service) {
			_service = service;
		}

		@PostMapping
		public ResponseEntity inserir(@RequestBody Banda banda) {
			_service.inserir(banda);
			return ResponseEntity.status(HttpStatus.CREATED).body("Banda Inserida com sucesso!");
		}
		
		@GetMapping
		public ResponseEntity listar() {
			Iterable<Banda> banda = _service.listar();
		return ResponseEntity.status(HttpStatus.OK).body(banda);
		}
		
		
}













