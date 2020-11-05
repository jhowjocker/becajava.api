package br.casadeshow.app.servicel;

import java.util.List;

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

	public void inserir(CasaDeShow casaDeShow) {
		casaDeShow.setId(0L);
		_repository.save(casaDeShow);
	}

	public List<CasaDeShow> listar() {
		return _repository.findAll();
	}
}
