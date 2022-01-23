package com.borges.diario_eletronico.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

/*Onde todas as requisições serão capturadas para autenticar*/
public class JWTAutenticacaoFilter extends GenericFilterBean{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		/*Estabelece a autenticação para a requisição*/

		Authentication authentication = new JWTTokenAutenticacaoService().getAuthentication((HttpServletRequest) request);
		
		/*Processo de autenticação do spring security*/
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		chain.doFilter(request, response);
	}
	
	
}
