package com.borges.diario_eletronico.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.borges.diario_eletronico.domain.Enturmacao;
import com.borges.diario_eletronico.service.EnturmacaoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/enturmacao")
public class EnturmacaoController {
	
	@Autowired
	private EnturmacaoService service;
	
	/**
	 * Buscar Aluno da turma pelo ID
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Enturmacao> findById(@PathVariable Integer id) {
		
		Enturmacao obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/*
	 * Busca todos os Alunos da turma da base de dados
	 */
	@GetMapping
	public ResponseEntity<List<Enturmacao>> findAll() {
		List<Enturmacao> listEnturmacao = service.findAll().stream().map(obj -> new Enturmacao(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listEnturmacao);

	}
	
	/*
	 * Atualizar um Aluno da turma
	 
	@PutMapping(value = "/{id}")
	public ResponseEntity<Enturmacao> update(@PathVariable Integer id, @RequestBody Enturmacao obj, Aluno obj1) {
		Enturmacao newObj = new Enturmacao(service.update(id, obj, obj1));
		
		return ResponseEntity.ok().body(newObj);
	}
	 */
	/*
	 * Adicionar um aluno da turma
	 */
	@PostMapping
	public ResponseEntity<Enturmacao> create(@Valid @RequestBody Enturmacao obj) {
		Enturmacao newObj = service.create(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	/*
	 * Delete um Aluno da turma pelo ID
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
}