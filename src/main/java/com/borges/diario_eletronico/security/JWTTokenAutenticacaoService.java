package com.borges.diario_eletronico.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Usuario;
import com.borges.diario_eletronico.repository.UsuarioRepository;
import com.borges.diario_eletronico.service.execeptions.DataIntegratyViolationException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
@Component
public class JWTTokenAutenticacaoService {
	
	/*Tempo de validação do token 2 dias*/
	private static final long EXPIARATION_TIME = 172800000;
	
	/*Senha unica para compor a autenticação e ajudar na seguraça*/
	private static final String SECRET = "SenhaExtremanteSecreta";
	
	/*Prefixo padrão do Token*/
	private static final String TOKEN_PREFIX = "Bearer";
	
	private static final String HEADER_STRING = "Authorization";
	
	/*Gerando token de autenticação e adicinar ao cabeçalho e resposta Http*/
	public void addAuthentication(HttpServletResponse response, String username) throws IOException {
		/*Montagem do Token*/
		String JWT = Jwts.builder()/*Chama o gerador de Token*/
						.setSubject(username)/*Adicina o usuario*/
						.setExpiration(new Date(System.currentTimeMillis() + EXPIARATION_TIME))/*Tempo de expiração*/
						.signWith(SignatureAlgorithm.HS512, SECRET).compact();/*Compactação e algoritmos de geração de senha*/
		
		/*Juntar token com prefixo*/
		String token = TOKEN_PREFIX + " " + JWT; /*Bearer 87878we8ew787w8e78e78w7e87w*/
		
		/*Adiciona no cabeçalho http*/
		response.addHeader(HEADER_STRING, token);/**/
		
		/*Escreve token como resposta no corpo http*/
		response.getWriter().write("{\"Authorization\": \""+token+ "\"}");
		
	}
	
	/**Retorna o usuario validado com token ou caso não seja valido retorna null*/
	public Authentication getAuthentication(HttpServletRequest request) {
		
		/*Pega o token enviado no cabeçalho http*/
		String token = request.getHeader(HEADER_STRING);
		
		if(token != null) {
			
			/*Faz a validação do token do usuário na requisição*/
			String user = Jwts.parser().setSigningKey(SECRET)/*Bearer 87878we8ew787w8e78e78w7e87w*/
						.parseClaimsJws(token.replace(TOKEN_PREFIX, ""))/*87878we8ew787w8e78e78w7e87w*/
						.getBody().getSubject();/*Exemplo: João Silva*/
		
			if(user != null) {
				
				Usuario usuario = ApplicationContextLoad.getApplicationContext()
								.getBean(UsuarioRepository.class).findByLogin(user);
				
				if(usuario != null) {
					
					return new UsernamePasswordAuthenticationToken(
							usuario.getLogin(),
							usuario.getSenha(),
							usuario.getAuthorities());
				}
				
			}
		
		}
		
		throw new DataIntegratyViolationException("Token não autorizado!");
		
	}
	
}

