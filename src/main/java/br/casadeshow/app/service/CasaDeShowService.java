package br.casadeshow.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.casadeshow.app.repository.*;
import br.casadeshow.app.model.*;

@Service

public class CasaDeShowService {

	final CasaDeShowRepository _repository;

	@Autowired
	public CasaDeShowService(CasaDeShowRepository repository) {
		_repository = repository;

	}

	public void inserir(CasaShow casaDeShow) {
		casaDeShow.setId(0L);
		_repository.save(casaDeShow);
	}

	public List<CasaShow> listar() {
		return _repository.findAll();
	}
	
	public Optional<CasaShow> obter(Long id){
		return _repository.findById(id);
	}
	
	public void atualizar(CasaShow casaShow,Long id) {
		casaShow.setId(id);
		_repository.save(casaShow);
	}
	
	public void deletar(Long id) {
		_repository.deleteById(id);
	}
}
