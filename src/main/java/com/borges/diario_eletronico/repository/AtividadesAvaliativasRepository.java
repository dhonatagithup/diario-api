package com.borges.diario_eletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.borges.diario_eletronico.domain.AtividadesAvaliativas;

@Repository
public interface AtividadesAvaliativasRepository extends JpaRepository<AtividadesAvaliativas, Integer> {
	
}
