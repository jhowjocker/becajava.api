package br.casadeshow.app.servicel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.casadeshow.app.repository.*;
import br.casadeshow.app.model.*;

@Service

public class PromocoesService {

	final PromocoesRepository _repository;
	
	@Autowired
	public PromocoesService(PromocoesRepository repository) {
		_repository = repository;
		
	}
	
	public void inserir(Promocoes promocoes) {
		promocoes.setId(0L);
		_repository.save(promocoes);
	}
	
	public List<Promocoes> listar(){
		return _repository.findAll();
	}
}
