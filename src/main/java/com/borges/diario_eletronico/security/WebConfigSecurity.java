package com.borges.diario_eletronico.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.borges.diario_eletronico.service.UsuarioService;


@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {

@Autowired
private UsuarioService usuarioService;	
	

/*Cinfigurar as solicitações de acesso por Http*/
@Override
protected void configure(HttpSecurity http) throws Exception {
    /*Ativando a proteção contra usuário que não validado por token*/
	http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
	
	/*Ativando a permissão para acesso a página inicial do sistema EX: sistema.com/index*/
		.disable().authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/login").permitAll()
		
	/*URL de logout - Redireciona após o use deslogar do sistema*/
		.anyRequest().authenticated().and().logout().logoutSuccessUrl("/login")
		
	/*Mapea URL de logout e invalida o usuário*/
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	
	/*Filtra requisições de login para autenticação*/
		.and().addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
				UsernamePasswordAuthenticationFilter.class)
				
	/*Filtra as demais requisições para verificar a presença do TOKEN JWT no HEADER HTTP*/
		.addFilterBefore(new JWTAutenticacaoFilter(), UsernamePasswordAuthenticationFilter.class);
}




@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
	/*Service que ira consultar o usuário no banco de dados*/
	auth.userDetailsService(usuarioService)
	
	/*Padrão de codificação de senha*/
	.passwordEncoder(new BCryptPasswordEncoder());
	
}
}
