package br.casadeshow.app.servicel;

import java.util.List;

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
}
