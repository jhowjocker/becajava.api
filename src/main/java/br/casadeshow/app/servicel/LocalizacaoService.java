package br.casadeshow.app.servicel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.casadeshow.app.repository.*;
import br.casadeshow.app.model.*;

@Service

public class LocalizacaoService {

	final LocalizacaoRepository _repository;
	
	@Autowired
	public LocalizacaoService(LocalizacaoRepository repository) {
		_repository = repository;
		
	}
	
	public void inserir(Localizacao localizacao) {
		localizacao.setId(0L);
		_repository.save(localizacao);
	}
	
	public List<Localizacao> listar(){
		return _repository.findAll();
	}
}
