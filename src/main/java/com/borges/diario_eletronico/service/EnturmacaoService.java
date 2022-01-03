package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Enturmacao;
import com.borges.diario_eletronico.repository.EnturmacaoRepository;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;


@Service
public class EnturmacaoService {
	
	@Autowired
	private EnturmacaoRepository enturmacaoRepository;
	
/**
	 * Buscar Aluno da turma pelo ID
	 */
	public Enturmacao findById(Integer id) {
		
		Optional<Enturmacao> obj = enturmacaoRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + Enturmacao.class.getName()));
	}
	
	/*
	 * Busca todos os Alunos da turma da base de dados
	 */
	public List<Enturmacao> findAll(){
		return enturmacaoRepository.findAll();
	}
	
	/*
	 * Atualizar um Aluno da turma
	 */
	
	public Enturmacao update(Integer id, Enturmacao obj) {
		
		Enturmacao oldObj = findById(id);
		
		oldObj.setDataEntrada(obj.getDataEntrada());
		oldObj.setDataSaida(obj.getDataSaida());
		oldObj.setAluno(obj.getAluno());
		oldObj.setProf(obj.getProf());
		
		
		return enturmacaoRepository.save(oldObj);
		
	}
	
	/*
	 * Adicionar um aluno da turma
	 */
	public Enturmacao create(Enturmacao obj) {
		
		
		return enturmacaoRepository.save(new Enturmacao(null, obj.getDataEntrada(), obj.getDataSaida(), obj.getAluno(), obj.getProf()));

	}
	
	/*
	 * Delete um Aluno da turma pelo ID
	 */
	public void delete(Integer id) {
		
		enturmacaoRepository.deleteById(id);
		
	}
	
}
