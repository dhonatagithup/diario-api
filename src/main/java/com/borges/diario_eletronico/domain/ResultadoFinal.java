package com.borges.diario_eletronico.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ResultadoFinal implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeAluno;
	private String bimestre;
	private Double totalAnualAulas;
	private Double cargaHoraria;
	private Integer totalFaltas;
	private Double notaFinal;
	private Integer situacaoAluno;
	
	public ResultadoFinal() {
		super();
		
	}

	public ResultadoFinal(Integer id, String nomeAluno, String bimestre, Double totalAnualAulas, Double cargaHoraria,
			Integer totalFaltas, Double notaFinal, Integer situacaoAluno) {
		super();
		this.id = id;
		this.nomeAluno = nomeAluno;
		this.bimestre = bimestre;
		this.totalAnualAulas = totalAnualAulas;
		this.cargaHoraria = cargaHoraria;
		this.totalFaltas = totalFaltas;
		this.notaFinal = notaFinal;
		this.situacaoAluno = situacaoAluno;
	}
	
	public ResultadoFinal(ResultadoFinal obj) {
		super();
		this.id = obj.getId();
		this.nomeAluno = obj.getNomeAluno();
		this.bimestre = obj.getBimestre();
		this.totalAnualAulas = obj.getTotalAnualAulas();
		this.cargaHoraria = obj.getCargaHoraria();
		this.totalFaltas = obj.getTotalFaltas();
		this.notaFinal = obj.getNotaFinal();
		this.situacaoAluno = obj.getSituacaoAluno();
	}

	@Override
	public String toString() {
		return "ResultadoFinal [id=" + id + ", nomeAluno=" + nomeAluno + ", bimestre=" + bimestre + ", totalAnualAulas="
				+ totalAnualAulas + ", cargaHoraria=" + cargaHoraria + ", totalFaltas=" + totalFaltas + ", notaFinal="
				+ notaFinal + ", situacaoAluno=" + situacaoAluno + "]";
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
		ResultadoFinal other = (ResultadoFinal) obj;
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

	public String getBimestre() {
		return bimestre;
	}

	public void setBimestre(String bimestre) {
		this.bimestre = bimestre;
	}

	public Double getTotalAnualAulas() {
		return totalAnualAulas;
	}

	public void setTotalAnualAulas(Double totalAnualAulas) {
		this.totalAnualAulas = totalAnualAulas;
	}

	public Double getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Double cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Integer getTotalFaltas() {
		return totalFaltas;
	}

	public void setTotalFaltas(Integer totalFaltas) {
		this.totalFaltas = totalFaltas;
	}

	public Double getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(Double notaFinal) {
		this.notaFinal = notaFinal;
	}

	public Integer getSituacaoAluno() {
		return situacaoAluno;
	}

	public void setSituacaoAluno(Integer situacaoAluno) {
		this.situacaoAluno = situacaoAluno;
	}
		
}
