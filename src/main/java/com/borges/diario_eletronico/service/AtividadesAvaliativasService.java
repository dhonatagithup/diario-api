package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.AtividadesAvaliativas;
import com.borges.diario_eletronico.repository.AtividadesAvaliativasRepository;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;


@Service
public class AtividadesAvaliativasService {
	
	@Autowired
	private AtividadesAvaliativasRepository repository;
	
	
	/**
	 * Buscar Atividades Avaliativas pelo ID
	 */
	public AtividadesAvaliativas findById(Integer id) {
		
		Optional<AtividadesAvaliativas> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + AtividadesAvaliativas.class.getName()));
	}
	
	/*
	 * Busca todas as  Atividades Avaliativas da base de dados
	 */
	public List<AtividadesAvaliativas> findAll(){
		return repository.findAll();
	}
	
	/*
	 * Atualizar uma  Atividades Avaliativas
	 */
	public AtividadesAvaliativas update(Integer id, AtividadesAvaliativas obj) {
		
		AtividadesAvaliativas oldObj = findById(id);

		oldObj.setNomeAluno(obj.getNomeAluno());
		oldObj.setCargaHorariaCumprida(obj.getCargaHorariaCumprida());
		oldObj.setBimestre(obj.getBimestre());
		oldObj.setTrabalho(obj.getTrabalho());
		oldObj.setAvaliacao(obj.getAvaliacao());
		oldObj.setParticipacao(obj.getParticipacao());
		oldObj.setTotalNota(obj.getTotalNota());
		
		return repository.save(oldObj);
	
	}
	
	/*
	 * Cria uma  Atividades Avaliativas
	 */
	public AtividadesAvaliativas create(AtividadesAvaliativas obj) {
		
		return repository.save(new AtividadesAvaliativas(null, obj.getNomeAluno(), obj.getCargaHorariaCumprida(), obj.getBimestre(), obj.getTrabalho(),
				obj.getAvaliacao(), obj.getParticipacao(), obj.getTotalNota()));

	}
	
}
