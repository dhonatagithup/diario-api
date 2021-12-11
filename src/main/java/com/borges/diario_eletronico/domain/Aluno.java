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

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class Aluno extends Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Campo NOME não pode ser vasio!")
	private String nome;
	
	@NotNull(message = "Campo NASCIMENTO não pode ser vasio!")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "nascimento")
	private Date nascimento;
	
	@NotBlank(message = "Campo SEXO não pode ser vasio!")
	private String sexo;
	
	@CPF
	@NotBlank(message = "Campo CPF não pode ser vasio!")
	private String cpf;
	
	@NotBlank(message = "Campo RG não pode ser vasio!")
	@Length(max=12, message = "O RG não pode ser maior que {max} caracteres!")
	@Column(name = "rg", length =12, nullable = false)
	private String rg;
	
	@NotBlank(message = "Campo TELEFONE não pode ser vasio!")
	private String telefone;
	
	@NotBlank(message = "Campo ENDEREÇO não pode ser vasio!")
	private String endereco;
	
	@NotNull(message = "Campo NÚMERO não pode ser vasio!")
	private Integer numero;
	
	@NotBlank(message = "Campo BAIRRO não pode ser vasio!")
	private String bairro;
	
	@NotBlank(message = "Campo CEP não pode ser vasio!")
	private String cep; 
	
	@NotBlank(message = "Campo CIDADE não pode ser vasio!")
	private String cidade;
	
	@NotBlank(message = "Campo ESTADO não pode ser vasio!")
	private String estado;
	
	@NotBlank(message = "Campo ZONA não pode ser vasio!")
	private String zona;
	
	@NotNull(message = "Campo MATRÍCULA não pode ser vasio!")
	private Integer matricula;
	
	@NotBlank(message = "Campo RESPONSÁVEL não pode ser vasio!")
	private String responsavel;
	
	public Aluno() {
		super();
	
	}
	
	

	

	public Aluno(Integer id, String nome, Date nascimento, String sexo, String cpf, String rg, String telefone, 
	String endereco, Integer numero, String bairro, String cep, String cidade, String estado, String zona,
	Integer matricula, String responsavel) {
		super();
		this.id = id;
		this.nome = nome;
		this.nascimento = nascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone = telefone;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.zona = zona;
		this.matricula = matricula;
		this.responsavel = responsavel;
	}





	public Aluno(Aluno obj) {
		super();
	    this.id = obj.getId();
		this.nome = obj.getNome();
		this.nascimento = obj.getNascimento();
		this.sexo = obj.getSexo();
		this.cpf = obj.getCpf();
		this.rg = obj.getRg();
		this.telefone = obj.getTelefone();
		this.endereco = obj.getEndereco();
		this.numero = obj.getNumero();
		this.bairro = obj.getBairro();
		this.cep = obj.getCep();
		this.cidade = obj.getCidade();
		this.estado = obj.getEstado();
		this.zona = obj.getZona();
		this.matricula = obj.getMatricula();
		this.responsavel = obj.getResponsavel();
		
	}

	public Integer getId() {
		return id;
	}
	

	public void setId(Integer id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}
	
	public Integer getMatricula() {
		return matricula;
	}
	
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
			
	public String getResponsavel() {
		return responsavel;
	}
	
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
		
}
