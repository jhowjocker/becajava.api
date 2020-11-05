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
@RequestMapping("/CasaShow")
public class CasaDeShowController {
	
		public CasaDeShowService _service;
		
		@Autowired
		public CasaDeShowController(CasaDeShowService service) {
			_service = service;
		}

		@PostMapping
		public ResponseEntity inserir(@RequestBody CasaDeShow casadeshow) {
			_service.inserir(casadeshow);
			return ResponseEntity.status(HttpStatus.CREATED).body("Casa de Show Inserida com sucesso!");
		}
		
		@GetMapping
		public ResponseEntity listar() {
			Iterable<CasaDeShow> casadeshow = _service.listar();
		return ResponseEntity.status(HttpStatus.OK).body(casadeshow);
		}
}
		