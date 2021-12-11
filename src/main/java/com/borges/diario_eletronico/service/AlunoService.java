package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Aluno;
import com.borges.diario_eletronico.repository.AlunoRepository;
import com.borges.diario_eletronico.service.execeptions.DataIntegratyViolationException;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;


@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	
	/**
	 * Buscar Aluno pelo ID
	 */
	public Aluno findById(Integer id) {
		
		Optional<Aluno> obj = alunoRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + Aluno.class.getName()));
	}
	
	/*
	 * Busca todos os Alunos da base de dados
	 */
	public List<Aluno> findAll(){
		return alunoRepository.findAll();
	}
	
	/*
	 * Atualizar um Aluno
	 */
	public Aluno update(Integer id, Aluno obj) {
		
		Aluno oldObj = findById(id);

		if (findByCPF(obj) != null && findByCPF(obj).getId() != id) {
			
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
			
		}
			
		oldObj.setNome(obj.getNome());
		oldObj.setNascimento(obj.getNascimento());
		oldObj.setSexo(obj.getSexo());
		oldObj.setCpf(obj.getCpf());
		oldObj.setRg(obj.getRg());
		oldObj.setTelefone(obj.getTelefone());
		oldObj.setEndereco(obj.getEndereco());
		oldObj.setNumero(obj.getNumero());
		oldObj.setBairro(obj.getBairro());
		oldObj.setCep(obj.getCep());
		oldObj.setCidade(obj.getCidade());
		oldObj.setEstado(obj.getEstado());
		oldObj.setZona(obj.getZona());
		oldObj.setMatricula(obj.getMatricula());
		oldObj.setResponsavel(obj.getResponsavel());
		
		return alunoRepository.save(oldObj);
	
	}
	
	/*
	 * Cria um Aluno
	 */
	public Aluno create(Aluno obj) {
		
		if(findByCPF(obj) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}

		return alunoRepository.save(new Aluno(null, obj.getNome(), obj.getNascimento(), obj.getSexo(), obj.getCpf(), obj.getRg(),
											  obj.getTelefone(), obj.getEndereco(),obj.getNumero(), obj.getBairro(), obj.getCep(),
											  obj.getCidade(), obj.getEstado(), obj.getZona(), obj.getMatricula(), obj.getResponsavel()));

	}
	
	/*
	 * Delete um Aluno pelo ID
	 */
	public void delete(Integer id) {
		
		alunoRepository.deleteById(id);
		
	}
	
	/*
	 * 	Busca o Aluno pelo CPF	
	 */
	private Aluno findByCPF(Aluno obj1){
		Aluno obj = alunoRepository.findByCPF(obj1.getCpf());
		if (obj != null) {
			return obj;
		}
		return null;
	}
	
	
	
}
