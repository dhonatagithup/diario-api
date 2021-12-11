package com.borges.diario_eletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.borges.diario_eletronico.domain.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Integer> {
	// Metodo findByCPF da camada de acesso a dados
	
		@Query("SELECT obj FROM Profissional obj WHERE obj.cpf =:cpf ")
		Profissional findByCPF(@Param("cpf") String cpf);

}
