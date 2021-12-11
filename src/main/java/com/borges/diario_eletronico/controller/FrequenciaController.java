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

import com.borges.diario_eletronico.domain.Frequencia;
import com.borges.diario_eletronico.service.FrequenciaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/frequencia")
public class FrequenciaController {
	
	@Autowired
	private FrequenciaService service;
	
	/**
	 * Buscar Frequencia pelo ID
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Frequencia> findById(@PathVariable Integer id) {
		
		Frequencia obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/*
	 * Busca todos as Frequencias da base de dados
	 */
	@GetMapping
	public ResponseEntity<List<Frequencia>> findAll() {
		List<Frequencia> listFrequencia = service.findAll().stream().map(obj -> new Frequencia(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listFrequencia);

	}
	
	/*
	 * Atualizar um Frequencia
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<Frequencia> update(@PathVariable Integer id, @RequestBody Frequencia obj) {
		Frequencia newObj = new Frequencia(service.update(id, obj));
		
		return ResponseEntity.ok().body(newObj);
	}
	
	/*
	 * Cria um Frequencia
	 */
	@PostMapping
	public ResponseEntity<Frequencia> create(@Valid @RequestBody Frequencia obj) {
		Frequencia newObj = service.create(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	/*
	 *  Delete um Frequencia
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
}