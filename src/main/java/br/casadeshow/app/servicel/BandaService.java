package br.casadeshow.app.servicel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.casadeshow.app.repository.*;
import br.casadeshow.app.model.*;

@Service

public class BandaService {

	final BandaRepository _repository;
	
	@Autowired
	public BandaService(BandaRepository repository) {
		_repository = repository;
		
	}
	
	public void inserir(Banda banda) {
		banda.setId(0L);
		_repository.save(banda);
	}
	
	public List<Banda> listar(){
		return _repository.findAll();
	}
	
	public Optional<Banda> obter(Long id){
		return _repository.findById(id);
	}
	
	public void atualizar(Banda banda,Long id) {
		banda.setId(id);
		_repository.save(banda);
	}
	
	public void deletar(Long id) {
		_repository.deleteById(id);
	}
	
}










