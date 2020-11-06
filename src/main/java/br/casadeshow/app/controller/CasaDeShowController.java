package br.casadeshow.app.controller;

import java.util.ArrayList;
import java.util.Optional;

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

import br.casadeshow.app.model.*;
import br.casadeshow.app.service.*;

@RestController
@RequestMapping("/CasaShow")
public class CasaDeShowController {

	public CasaDeShowService _service;

	@Autowired
	public CasaDeShowController(CasaDeShowService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity inserir(@RequestBody CasaShow casadeshow) {
		try {
			_service.inserir(casadeshow);
			return ResponseEntity.status(HttpStatus.CREATED).body("Casa de Show Inserida com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}
	}

	@GetMapping
	public ResponseEntity listar() {
		try {
			Iterable<CasaShow> casadeshow = _service.listar();
			return ResponseEntity.status(HttpStatus.OK).body(casadeshow);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}

	}

	@GetMapping(path = "/{id}")
	public ResponseEntity obter(@PathVariable Long id) {
		try {
			Optional<CasaShow> casaShow = _service.obter(id);
			return ResponseEntity.status(HttpStatus.OK).body(casaShow);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody CasaShow casaShow, @PathVariable Long id) {
		try {
			_service.atualizar(casaShow, id);
			return ResponseEntity.status(HttpStatus.OK).body("CasaShow atualizada com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		try {
			_service.deletar(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro na aplicação!");
		}
	}
}
