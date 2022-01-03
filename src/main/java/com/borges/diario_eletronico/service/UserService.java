package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.User;
import com.borges.diario_eletronico.repository.UserRepository;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	

	private final PasswordEncoder encoder;
	
	public UserService(UserRepository repository, PasswordEncoder encoder) {
		this.userRepository = repository;
		this.encoder = encoder;
	
	}
	
	 /**
	  * * Buscar Usuarios pelo ID
	  */
	 
	public User findById(Integer id) {
		
		Optional<User> obj = userRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + User.class.getName()));
	}
	
	
	  /**
	   * Busca todos os Usuarios da base de dados
	   */
	 
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	
	  /*
	   * Cria um Usuario
	   */
	 
	public User create(User obj) {
		
		obj.setPassword(encoder.encode(obj.getPassword()));
		
		return userRepository.save(new User(null, obj.getLogin(), obj.getPassword()));

	}
	
	
}
