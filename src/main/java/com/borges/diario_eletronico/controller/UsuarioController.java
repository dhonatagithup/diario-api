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

import com.borges.diario_eletronico.domain.Usuario;
import com.borges.diario_eletronico.service.UsuarioService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	
	/**
	 * Buscar Usuario pelo ID
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
		
		Usuario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/*
	 * Busca todos os Usuario da base de dados
	 */
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> listUsuario = service.findAll().stream().map(obj -> new Usuario(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listUsuario);

	}
	
	/*
	 * Atualizar um Usuario
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario obj) {
		Usuario newObj = new Usuario(service.update(id, obj));
		
		return ResponseEntity.ok().body(newObj);
	}
	
	/*
	 * Cria um Usuario
	 */
	@PostMapping
	public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario obj) {
		Usuario newObj = service.create(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	/*
	 *  Delete um Usuario
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	
}