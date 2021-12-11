package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.ResultadoFinal;
import com.borges.diario_eletronico.repository.ResultadoFinalRepository;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;


@Service
public class ResultadoFinalService {
	
	@Autowired
	private ResultadoFinalRepository repository;
	
	
	/**
	 * Buscar Resultado Final pelo ID
	 */
	public ResultadoFinal findById(Integer id) {
		
		Optional<ResultadoFinal> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + ResultadoFinal.class.getName()));
	}
	
	/*
	 * Busca todas as  Resultado Final da base de dados
	 */
	public List<ResultadoFinal> findAll(){
		return repository.findAll();
	}
	
}
