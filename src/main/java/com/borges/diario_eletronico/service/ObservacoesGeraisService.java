package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.ObservacoesGerais;
import com.borges.diario_eletronico.repository.ObservacoesGeraisRepository;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;


@Service
public class ObservacoesGeraisService {
	
	@Autowired
	private ObservacoesGeraisRepository observacoesGeraisRepository;
	
	
	/**
	 * Buscar Observação pelo ID
	 */
	public ObservacoesGerais findById(Integer id) {
		
		Optional<ObservacoesGerais> obj = observacoesGeraisRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + ObservacoesGerais.class.getName()));
	}
	
	/*
	 * Busca todas as Observações da base de dados
	 */
	public List<ObservacoesGerais> findAll(){
		return observacoesGeraisRepository.findAll();
	}
	
	/*
	 * Atualizar uma Observação
	 */
	public ObservacoesGerais update(Integer id, ObservacoesGerais obj) {
		
		ObservacoesGerais oldObj = findById(id);

		oldObj.setDataObs(obj.getDataObs());;
		oldObj.setCampoObs(obj.getCampoObs());
		
		
		return observacoesGeraisRepository.save(oldObj);
	
	}
	
	/*
	 * Cria uma Observação
	 */
	public ObservacoesGerais create(ObservacoesGerais obj) {
		
		return observacoesGeraisRepository.save(new ObservacoesGerais(null, obj.getDataObs(), obj.getCampoObs()));

	}
	
	/*
	 * Delete uma Observação pelo ID
	 */
	public void delete(Integer id) {
		
		observacoesGeraisRepository.deleteById(id);
		
	}	
	
}
