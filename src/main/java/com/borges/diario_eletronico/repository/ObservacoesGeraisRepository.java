package com.borges.diario_eletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.borges.diario_eletronico.domain.ObservacoesGerais;

public interface ObservacoesGeraisRepository extends JpaRepository<ObservacoesGerais, Integer> {
	
}
