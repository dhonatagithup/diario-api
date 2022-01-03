package com.borges.diario_eletronico.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.borges.diario_eletronico.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public Optional<User>findByLogin(String login);

}
