package com.borges.diario_eletronico.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.borges.diario_eletronico.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

//Usuario findByEmail(String email);
	@Query("select obj from Usuario obj where obj.login = ?1")
	 Usuario findByLogin(String login);

}
