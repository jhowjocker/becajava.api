package br.casadeshow.app.servicel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.casadeshow.app.repository.*;
import br.casadeshow.app.model.*;

@Service

public class EventoService {

	final EventoRepository _repository;
	
	@Autowired
	public EventoService(EventoRepository repository) {
		_repository = repository;
		
	}
	
	public void inserir(Evento evento) {
		evento.setId(0L);
		_repository.save (evento);
	}
	
	public List<Evento> listar(){
		return _repository.findAll();
	}
	
	public Optional<Evento> obter(Long id){
		return _repository.findById(id);
	}
	
	public void atualizar(Evento evento,Long id) {
		evento.setId(id);
		_repository.save(evento);
	}
	
	public void deletar(Long id) {
		_repository.deleteById(id);
	}
}
