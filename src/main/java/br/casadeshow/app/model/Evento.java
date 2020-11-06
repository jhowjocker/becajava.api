package br.casadeshow.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "BandaId")
	private Banda banda;
	
	@ManyToOne
	@JoinColumn(name = "CasaShowId")
	private CasaShow casaShow;
		
	@ManyToOne
	@JoinColumn(name = "LocalId")
	private Local local;
	
	
	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	public CasaShow getCasaShow() {
		return casaShow;
	}

	public void setCasaShow(CasaShow casaShow) {
		this.casaShow = casaShow;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}