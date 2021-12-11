package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Profissional;
import com.borges.diario_eletronico.repository.ProfissionalRepository;
import com.borges.diario_eletronico.service.execeptions.DataIntegratyViolationException;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;

@Service
public class ProfissionalService {
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	/**
	 * Buscar Profissional pelo ID
	 */
	public Profissional findById(Integer id) {
		
		Optional<Profissional> obj = profissionalRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + Profissional.class.getName()));
	}
	
	/*
	 * Busca todos os Profissional da base de dados
	 */
	public List<Profissional> findAll(){
		return profissionalRepository.findAll();
	}
	
	/*
	 * Atualizar um Profissional
	 */
	public Profissional update(Integer id, Profissional obj) {
		
		Profissional oldObj = findById(id);
		
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
		oldObj.setCargo(obj.getCargo()); 
		oldObj.setTurma(obj.getTurma()); 
		oldObj.setDisciplina(obj.getDisciplina()); 
		oldObj.setEmail(obj.getEmail()); 
		oldObj.setSenha(obj.getSenha()); 
		
		return profissionalRepository.save(oldObj);
	
	}
	
	/*
	 * Cria um Profissional
	 */
	public Profissional create(Profissional obj) {
		
		if(findByCPF(obj) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}
		
		return profissionalRepository.save(new Profissional(null, obj.getNome(), obj.getNascimento(), obj.getSexo(), obj.getCpf(), obj.getRg(),
											  obj.getTelefone(), obj.getEndereco(),obj.getNumero(), obj.getBairro(), obj.getCep(),
											  obj.getCidade(), obj.getEstado(), obj.getZona(), obj.getCargo(), obj.getTurma(),
											  obj.getDisciplina(), obj.getEmail(), obj.getSenha()));

	}
	
	/*
	 * Delete um Profissional pelo ID
	 */
	public void delete(Integer id) {
		
		profissionalRepository.deleteById(id);
		
	}

	/*
	 * 	Busca o Aluno pelo CPF	
	 */
	private Profissional findByCPF(Profissional obj1){
		Profissional obj = profissionalRepository.findByCPF(obj1.getCpf());
		if (obj != null) {
			return obj;
		}
		return null;
	}
	

}
