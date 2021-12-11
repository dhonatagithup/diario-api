package com.borges.diario_eletronico.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Frequencia implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nomeAluno;
	private String disciplina;
	private Double aulasPrevistas;
	private Double aulasCumpridas;
	private String frequenciaAluno;
	private Integer totalFaltas;
	
	public Frequencia() {
		super();
	}

	public Frequencia(Integer id, String nomeAluno, String disciplina, Double aulasPrevistas, Double aulasCumpridas,
			String frequenciaAluno, Integer totalFaltas) {
		super();
		this.id = id;
		this.nomeAluno = nomeAluno;
		this.disciplina = disciplina;
		this.aulasPrevistas = aulasPrevistas;
		this.aulasCumpridas = aulasCumpridas;
		this.frequenciaAluno = frequenciaAluno;
		this.totalFaltas = totalFaltas;
	}
	
	
	
	public Frequencia(Frequencia obj) {
		super();
		this.id = obj.getId();
		this.nomeAluno = obj.getNomeAluno();
		this.disciplina = obj.getDisciplina();
		this.aulasPrevistas = obj.getAulasPrevistas();
		this.aulasCumpridas = obj.getAulasCumpridas();
		this.frequenciaAluno = obj.getFrequenciaAluno();
		this.totalFaltas = obj.getTotalFaltas();
	}

	@Override
	public String toString() {
		return "Frequencia [id=" + id + ", nomeAluno=" + nomeAluno + ", disciplina=" + disciplina + ", aulasPrevistas="
				+ aulasPrevistas + ", aulasCumpridas=" + aulasCumpridas + ", frequenciaAluno=" + frequenciaAluno
				+ ", totalfaltas=" + totalFaltas + "]";
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
		Frequencia other = (Frequencia) obj;
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

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public Double getAulasPrevistas() {
		return aulasPrevistas;
	}

	public void setAulasPrevistas(Double aulasPrevistas) {
		this.aulasPrevistas = aulasPrevistas;
	}

	public Double getAulasCumpridas() {
		return aulasCumpridas;
	}

	public void setAulasCumpridas(Double aulasCumpridas) {
		this.aulasCumpridas = aulasCumpridas;
	}

	public String getFrequenciaAluno() {
		return frequenciaAluno;
	}

	public void setFrequenciaAluno(String frequenciaAluno) {
		this.frequenciaAluno = frequenciaAluno;
	}

	public Integer getTotalFaltas() {
		return totalFaltas;
	}

	public void setTotalFaltas(Integer totalfaltas) {
		this.totalFaltas = totalfaltas;
	}	
	
}
