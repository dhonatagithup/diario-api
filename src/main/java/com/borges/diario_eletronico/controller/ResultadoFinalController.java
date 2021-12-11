package com.borges.diario_eletronico.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.borges.diario_eletronico.domain.ResultadoFinal;
import com.borges.diario_eletronico.service.ResultadoFinalService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/resultadoFinal")
public class ResultadoFinalController {
	
	@Autowired
	private ResultadoFinalService service;
	
	/**
	 * Buscar Frequencia pelo ID
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResultadoFinal> findById(@PathVariable Integer id) {
		
		ResultadoFinal obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/*
	 * Busca todos as Frequencias da base de dados
	 */
	@GetMapping
	public ResponseEntity<List<ResultadoFinal>> findAll() {
		List<ResultadoFinal> listResultadoFinal = service.findAll().stream().map(obj -> new ResultadoFinal(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listResultadoFinal);

	}
	
}