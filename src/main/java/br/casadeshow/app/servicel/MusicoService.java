package br.casadeshow.app.servicel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.casadeshow.app.repository.*;
import br.casadeshow.app.model.*;

@Service

public class MusicoService {

	final MusicoRepository _repository;
	
	@Autowired
	public MusicoService(MusicoRepository repository) {
		_repository = repository;
		
	}
	
	public void inserir(Musico musico) {
		musico.setId(0L);
		_repository.save(musico);
	}
	
	public List<Musico> listar(){
		return _repository.findAll();
	}
}
