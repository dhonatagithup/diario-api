package com.borges.diario_eletronico.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.borges.diario_eletronico.domain.AtividadesAvaliativas;
import com.borges.diario_eletronico.service.AtividadesAvaliativasService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/atividadesAvaliativas")
public class AtividadesAvaliativasController {
	
	@Autowired
	private AtividadesAvaliativasService service;
	
	/**
	 * Buscar Aulas Lecionadas pelo ID
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<AtividadesAvaliativas> findById(@PathVariable Integer id) {
		
		AtividadesAvaliativas obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/*
	 * Busca todos as Aulas Lecionadas da base de dados
	 */
	@GetMapping
	public ResponseEntity<List<AtividadesAvaliativas>> findAll() {
		List<AtividadesAvaliativas> listAtividadesAvaliativas = service.findAll().stream().map(obj -> new AtividadesAvaliativas(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listAtividadesAvaliativas);

	}
	
	/*
	 * Atualizar um Aula Lecionada
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<AtividadesAvaliativas> update(@PathVariable Integer id, @RequestBody AtividadesAvaliativas obj) {
		AtividadesAvaliativas newObj = new AtividadesAvaliativas(service.update(id, obj));
		
		return ResponseEntity.ok().body(newObj);
	}
	
	/*
	 * Cria um Aula Lecionada
	 */
	@PostMapping
	public ResponseEntity<AtividadesAvaliativas> create(@Valid @RequestBody AtividadesAvaliativas obj) {
		AtividadesAvaliativas newObj = service.create(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
}