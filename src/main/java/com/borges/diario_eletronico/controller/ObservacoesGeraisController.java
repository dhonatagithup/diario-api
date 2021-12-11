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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.borges.diario_eletronico.domain.ObservacoesGerais;
import com.borges.diario_eletronico.service.ObservacoesGeraisService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/observacoes")
public class ObservacoesGeraisController {
	
	@Autowired
	private ObservacoesGeraisService service;
	
	/**
	 * Buscar Observações pelo ID
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<ObservacoesGerais> findById(@PathVariable Integer id) {
		
		ObservacoesGerais obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/*
	 * Busca todos as Observações da base de dados
	 */
	@GetMapping
	public ResponseEntity<List<ObservacoesGerais>> findAll() {
		List<ObservacoesGerais> listObs = service.findAll().stream().map(obj -> new ObservacoesGerais(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listObs);

	}
	
	/*
	 * Atualizar uma Observação
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<ObservacoesGerais> update(@PathVariable Integer id, @RequestBody ObservacoesGerais obj) {
		ObservacoesGerais newObj = new ObservacoesGerais(service.update(id, obj));
		
		return ResponseEntity.ok().body(newObj);
	}
	
	/*
	 * Cria uma Observação
	 */
	@PostMapping
	public ResponseEntity<ObservacoesGerais> create(@Valid @RequestBody ObservacoesGerais obj) {
		ObservacoesGerais newObj = service.create(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	/*
	 *  Delete uma Observação
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
}