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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class AulasLecionadas implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "dataAula")
	private Date dataAula;	
	
	@NotBlank(message = "Informe o BIMESTRE por favor!")
	private String bimestre;
	
	@NotBlank(message = "Informe o DISCIPLINA por favor!")
	private String disciplina;
	
	@NotBlank(message = "Informe as OBSERVAÇÕES por favor!")
	private String obsAulas;
	
	public AulasLecionadas() {
		super();
	}

	public AulasLecionadas(Integer id, Date dataAula, String bimestre, String disciplina, String obsAulas) {
		super();
		this.id = id;
		this.dataAula = dataAula;
		this.bimestre = bimestre;
		this.disciplina = disciplina;
		this.obsAulas = obsAulas;
	}
	
	public AulasLecionadas(AulasLecionadas obj) {
		super();
		this.id = obj.getId();
		this.dataAula = obj.getDataAula();
		this.bimestre = obj.getBimestre();
		this.disciplina = obj.getDisciplina();
		this.obsAulas = obj.getObsAulas();
	}


	@Override
	public String toString() {
		return "AulasLecionadas [id=" + id + ", dataAula=" + dataAula + ", bimestre=" + bimestre + ", disciplina="
				+ disciplina + ", obsAulas=" + obsAulas + "]";
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
		AulasLecionadas other = (AulasLecionadas) obj;
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

	public Date getDataAula() {
		return dataAula;
	}

	public void setDataAula(Date dataAula) {
		this.dataAula = dataAula;
	}

	public String getBimestre() {
		return bimestre;
	}

	public void setBimestre(String bimestre) {
		this.bimestre = bimestre;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getObsAulas() {
		return obsAulas;
	}

	public void setObsAulas(String obsAulas) {
		this.obsAulas = obsAulas;
	}
	
	
	
}
