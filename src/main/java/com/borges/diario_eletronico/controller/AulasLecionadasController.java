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

import com.borges.diario_eletronico.domain.AulasLecionadas;
import com.borges.diario_eletronico.service.AulasLecionadasService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/aulasLecionadas")
public class AulasLecionadasController {
	
	@Autowired
	private AulasLecionadasService service;
	
	/**
	 * Buscar Aulas Lecionadas pelo ID
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<AulasLecionadas> findById(@PathVariable Integer id) {
		
		AulasLecionadas obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/*
	 * Busca todos as Aulas Lecionadas da base de dados
	 */
	@GetMapping
	public ResponseEntity<List<AulasLecionadas>> findAll() {
		List<AulasLecionadas> listAulas = service.findAll().stream().map(obj -> new AulasLecionadas(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listAulas);

	}
	
	/*
	 * Atualizar um Aula Lecionada
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<AulasLecionadas> update(@PathVariable Integer id, @RequestBody AulasLecionadas obj) {
		AulasLecionadas newObj = new AulasLecionadas(service.update(id, obj));
		
		return ResponseEntity.ok().body(newObj);
	}
	
	/*
	 * Cria um Aula Lecionada
	 */
	@PostMapping
	public ResponseEntity<AulasLecionadas> create(@Valid @RequestBody AulasLecionadas obj) {
		AulasLecionadas newObj = service.create(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	/*
	 *  Delete um Aula Lecionada
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
}