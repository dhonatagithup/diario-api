package com.borges.diario_eletronico.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AtividadesAvaliativas implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nomeAluno;
	private Double cargaHorariaCumprida;
	private String bimestre;
	private Double trabalho;
	private Double avaliacao;
	private Double participacao;
	private Double totalNota;
	
	public AtividadesAvaliativas() {
		super();
		
	}

	public AtividadesAvaliativas(Integer id, String nomeAluno, Double cargaHorariaCumprida, String bimestre,
			Double trabalho, Double avaliacao, Double participacao, Double totalNota) {
		super();
		this.id = id;
		this.nomeAluno = nomeAluno;
		this.cargaHorariaCumprida = cargaHorariaCumprida;
		this.bimestre = bimestre;
		this.trabalho = trabalho;
		this.avaliacao = avaliacao;
		this.participacao = participacao;
		this.totalNota = totalNota;
	}
	
	public AtividadesAvaliativas(AtividadesAvaliativas obj) {
		super();
		this.id = obj.getId();
		this.nomeAluno = obj.getNomeAluno();
		this.cargaHorariaCumprida = obj.getCargaHorariaCumprida();
		this.bimestre = obj.getBimestre();
		this.trabalho = obj.getTrabalho();
		this.avaliacao = obj.getAvaliacao();
		this.participacao = obj.getParticipacao();
		this.totalNota = obj.getTotalNota();
	}


	@Override
	public String toString() {
		return "AtividadesAvaliativas [id=" + id + ", nomeAluno=" + nomeAluno + ", cargaHorariaCumprida="
				+ cargaHorariaCumprida + ", bimestre=" + bimestre + ", trabalho=" + trabalho + ", avaliacao="
				+ avaliacao + ", participacao=" + participacao + ", totalNota=" + totalNota + "]";
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
		AtividadesAvaliativas other = (AtividadesAvaliativas) obj;
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

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public Double getCargaHorariaCumprida() {
		return cargaHorariaCumprida;
	}

	public void setCargaHorariaCumprida(Double cargaHorariaCumprida) {
		this.cargaHorariaCumprida = cargaHorariaCumprida;
	}

	public String getBimestre() {
		return bimestre;
	}

	public void setBimestre(String bimestre) {
		this.bimestre = bimestre;
	}

	public Double getTrabalho() {
		return trabalho;
	}

	public void setTrabalho(Double trabalho) {
		this.trabalho = trabalho;
	}

	public Double getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Double avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Double getParticipacao() {
		return participacao;
	}

	public void setParticipacao(Double participacao) {
		this.participacao = participacao;
	}

	public Double getTotalNota() {
		return totalNota;
	}

	public void setTotalNota(Double totalNota) {
		this.totalNota = totalNota;
	}
	
	
	
}
