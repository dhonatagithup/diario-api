package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.AulasLecionadas;
import com.borges.diario_eletronico.repository.AulasLecionadasRepository;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;


@Service
public class AulasLecionadasService {
	
	@Autowired
	private AulasLecionadasRepository repository;
	
	
	/**
	 * Buscar Aulas Lecionada pelo ID
	 */
	public AulasLecionadas findById(Integer id) {
		
		Optional<AulasLecionadas> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + AulasLecionadas.class.getName()));
	}
	
	/*
	 * Busca todas as Aulas Lecionada da base de dados
	 */
	public List<AulasLecionadas> findAll(){
		return repository.findAll();
	}
	
	/*
	 * Atualizar uma Aula Lecionada
	 */
	public AulasLecionadas update(Integer id, AulasLecionadas obj) {
		
		AulasLecionadas oldObj = findById(id);

		oldObj.setDataAula(obj.getDataAula());;
		oldObj.setBimestre(obj.getBimestre());
		oldObj.setDisciplina(obj.getDisciplina());
		oldObj.setObsAulas(obj.getObsAulas());		
		
		return repository.save(oldObj);
	
	}
	
	/*
	 * Cria uma Aula Lecionada
	 */
	public AulasLecionadas create(AulasLecionadas obj) {
		
		return repository.save(new AulasLecionadas(null, obj.getDataAula(), obj.getBimestre(), obj.getDisciplina(), obj.getObsAulas()));

	}
	
	/*
	 * Delete uma Aulas Lecionadas pelo ID
	 */
	public void delete(Integer id) {
		
		repository.deleteById(id);
		
	}	
	
}
