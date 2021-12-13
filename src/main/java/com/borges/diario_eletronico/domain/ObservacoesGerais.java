package com.borges.diario_eletronico.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class ObservacoesGerais implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "Selecione a DATA por favor!")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "dataObs")
	private Date dataObs;
	
	@NotBlank(message = "É necessario colocar a observação!")
	private String campoObs;
	
	public ObservacoesGerais() {
		super();
	}
	
	
	
	public ObservacoesGerais(Integer id, Date dataObs, String campoObs) {
		super();
		this.id = id;
		this.dataObs = dataObs;
		this.campoObs = campoObs;
	}

	public ObservacoesGerais(ObservacoesGerais obj) {
		super();
		this.id = obj.getId();
		this.dataObs = obj.getDataObs();
		this.campoObs = obj.getCampoObs();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObservacoesGerais other = (ObservacoesGerais) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataObs() {
		return dataObs;
	}

	public void setDataObs(Date dataObs) {
		this.dataObs = dataObs;
	}

	public String getCampoObs() {
		return campoObs;
	}

	public void setCampoObs(String campoObs) {
		this.campoObs = campoObs;
	}
	
}
