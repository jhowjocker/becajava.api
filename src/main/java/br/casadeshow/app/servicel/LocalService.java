package br.casadeshow.app.servicel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.casadeshow.app.repository.*;
import br.casadeshow.app.model.*;

@Service

public class LocalService {

	final LocalRepository _repository;
	
	@Autowired
	public LocalService(LocalRepository repository) {
		_repository = repository;
		
	}
	
	public void inserir(Local local) {
		local.setId(0L);
		_repository.save(local);
	}
	
	public List<Local> listar(){
		return _repository.findAll();
	}
	
	public Optional<Local> obter(Long id){
		return _repository.findById(id);
	}
	
	public void atualizar(Local local,Long id) {
		local.setId(id);
		_repository.save(local);
	}
	
	public void deletar(Long id) {
		_repository.deleteById(id);
	}
}
