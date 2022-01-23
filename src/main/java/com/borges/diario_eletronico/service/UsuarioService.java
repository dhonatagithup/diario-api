package com.borges.diario_eletronico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Usuario;
import com.borges.diario_eletronico.repository.UsuarioRepository;
import com.borges.diario_eletronico.service.execeptions.DataIntegratyViolationException;
import com.borges.diario_eletronico.service.execeptions.ObjectNotFoundException;


@Service
public class UsuarioService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		/*Consulta no banco o usuario*/
		
		Usuario usuario = usuarioRepository.findByLogin(username);
		
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario não encontrado!");
		}
		
		return new User(usuario.getLogin(), usuario.getSenha(), usuario.getAuthorities());
	}
		
	/**
	 * Buscar Usuario pelo ID
	 */
	public Usuario findById(Integer id) {
		
		Optional<Usuario> obj = usuarioRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + Usuario.class.getName()));
	}
	
	/*
	 * Busca todos os Usuarios da base de dados
	 */
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	/*
	 * Atualizar um Usuario
	 */
	public Usuario update(Integer id, Usuario obj) {
		
		Usuario oldObj = findById(id);

		if (findByLogin(obj) != null && findByLogin(obj).getId() != id) {
			
			throw new DataIntegratyViolationException("EMAIL já cadastrado na base de dados!");
			
		}
			
		oldObj.setLogin(obj.getLogin());
		oldObj.setSenha(obj.getSenha());
		oldObj.setNome(obj.getNome());
		oldObj.setRoles(obj.getRoles());


		return usuarioRepository.save(oldObj);
	
	}
	
	/*
	 * Cria um Usuario
	 */
	public Usuario create(Usuario obj) {
		
		if(findByLogin(obj) != null) {
			throw new DataIntegratyViolationException("EMAIL já cadastrado na base de dados!");
		}

		return usuarioRepository.save(new Usuario(null, obj.getLogin(), obj.getSenha(), obj.getNome(), obj.getRoles()));

	}
	
	/*
	 * Delete um Usuario pelo ID
	 */
	public void delete(Integer id) {
		
		usuarioRepository.deleteById(id);
		
	}
	
	/*
	 * 	Busca o Usuario pelo EMAIL	
	 */
	private Usuario findByLogin(Usuario obj1){
		Usuario obj = usuarioRepository.findByLogin(obj1.getLogin());
		if (obj != null) {
			return obj;
		}
		return null;
	}

	
	
}
