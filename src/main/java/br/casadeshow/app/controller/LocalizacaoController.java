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
@RequestMapping("/localizacao")
public class LocalizacaoController {
	
		public LocalizacaoService _service;
		
		@Autowired
		public LocalizacaoController(LocalizacaoService service) {
			_service = service;
		}

		@PostMapping
		public ResponseEntity inserir(@RequestBody Localizacao localizacao) {
			_service.inserir(localizacao);
			return ResponseEntity.status(HttpStatus.CREATED).body("Localização Inserida com sucesso!");
		}
		
		@GetMapping
		public ResponseEntity listar() {
			Iterable<Localizacao> localizacao= _service.listar();
		return ResponseEntity.status(HttpStatus.OK).body(localizacao);
		}
		
		
}
