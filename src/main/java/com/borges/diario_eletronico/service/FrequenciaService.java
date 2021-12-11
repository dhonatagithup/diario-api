package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Frequencia;
import com.borges.diario_eletronico.repository.FrequenciaRepository;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;


@Service
public class FrequenciaService {
	
	@Autowired
	private FrequenciaRepository repository;
		
	/**
	 * Buscar Frequencia pelo ID
	 */
	public Frequencia findById(Integer id) {
		
		Optional<Frequencia> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + Frequencia.class.getName()));
	}
	
	/*
	 * Busca todos as Frequencias da base de dados
	 */
	public List<Frequencia> findAll(){
		return repository.findAll();
	}
	
	/*
	 * Atualizar um Frequencia
	 */
	public Frequencia update(Integer id, Frequencia obj) {
		
		Frequencia oldObj = findById(id);
			
		oldObj.setNomeAluno(obj.getNomeAluno());
		oldObj.setDisciplina(obj.getDisciplina());
		oldObj.setAulasPrevistas(obj.getAulasPrevistas());
		oldObj.setAulasCumpridas(obj.getAulasCumpridas());
		oldObj.setFrequenciaAluno(obj.getFrequenciaAluno());
		oldObj.setTotalFaltas(obj.getTotalFaltas());
		
		return repository.save(oldObj);
	
	}
	
	/*
	 * Cria um Frequencia
	 */
	public Frequencia create(Frequencia obj) {
		
		return repository.save(new Frequencia(null, obj.getNomeAluno(), obj.getDisciplina(), obj.getAulasPrevistas(),
				obj.getAulasCumpridas(), obj.getFrequenciaAluno(), obj.getTotalFaltas()));

	}
	
	/*
	 * Delete um Frequencia pelo ID
	 */
	public void delete(Integer id) {
		
		repository.deleteById(id);
		
	}
	
}
