package com.borges.diario_eletronico.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.borges.diario_eletronico.domain.Aluno;
import com.borges.diario_eletronico.domain.AtividadesAvaliativas;
import com.borges.diario_eletronico.domain.AulasLecionadas;
import com.borges.diario_eletronico.domain.Frequencia;
import com.borges.diario_eletronico.domain.ObservacoesGerais;
import com.borges.diario_eletronico.domain.Profissional;
import com.borges.diario_eletronico.domain.ResultadoFinal;
import com.borges.diario_eletronico.repository.AlunoRepository;
import com.borges.diario_eletronico.repository.AtividadesAvaliativasRepository;
import com.borges.diario_eletronico.repository.AulasLecionadasRepository;
import com.borges.diario_eletronico.repository.FrequenciaRepository;
import com.borges.diario_eletronico.repository.ObservacoesGeraisRepository;
import com.borges.diario_eletronico.repository.ProfissionalRepository;
import com.borges.diario_eletronico.repository.ResultadoFinalRepository;

@Service
public class DBService {
	
	//LocalDateTime agora = LocalDateTime.now();
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	@Autowired
	private ObservacoesGeraisRepository observacoesRepository;
	
	@Autowired
	private AulasLecionadasRepository aulasLecionadasRepository;
	
	@Autowired
	private FrequenciaRepository frequenciaRepository;
	
	@Autowired
	private AtividadesAvaliativasRepository  atividadesAvaliativasRepository;
	
	@Autowired
	private ResultadoFinalRepository  resultadoFinalRepository ;
	
	
	public void instanciaDB() throws ParseException {	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		/*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		LocalDateTime dateTime = LocalDateTime.parse("2016-09-21 13:43:27.000", formatter);*/
		
		Aluno a1 = new Aluno(null, "João Borges", sdf.parse("25/06/1995"),"masculino", "133.120.446-18", "mg19.599.003", 
							"(38)99927-6907", "rua: batista", 17, "veredinha","38689-000","chapada",
							"minas Gerais", "urbana", 1206,"Joana Bispo");
			
		Profissional p1 = new Profissional(null, "Joana Marques",sdf.parse("25/06/1995"), "masculino", "957.443.730-20", "mg19.599.003", 
							"(38)99927-6907", "rua: batista", 17, "veredinha","38689-000","chapada",
							"minas Gerais", "urbana", "professor", "oitavo ano", "matematica", "joana@gmail.com", "senha123");
			
		ObservacoesGerais obs1 = new ObservacoesGerais(null, sdf.parse("25/06/1995"), "Campo de Obs.....");
		
		AulasLecionadas al1 = new AulasLecionadas(null, LocalDateTime.now(), "oitavo", "matematica", "Campo de Obs.....");
		
		Frequencia f1 = new Frequencia(null, "Josias Barbosa", "inglês", 10.0, 5.0, "f", 25);
		
		AtividadesAvaliativas at1 = new AtividadesAvaliativas(null, "João Batista", 65.40, "sexto bimestre", 40.0, 50.0, 5.0, 95.0);
		
		ResultadoFinal r1 = new ResultadoFinal(null, "João Batista", "oitado ano", 78.0, 65.0, 25, 78.0, 1 );
		
		alunoRepository.saveAll(Arrays.asList(a1));
		
		profissionalRepository.saveAll(Arrays.asList(p1));
		
		observacoesRepository.saveAll(Arrays.asList(obs1));
		
		aulasLecionadasRepository.saveAll(Arrays.asList(al1));
		
		frequenciaRepository.saveAll(Arrays.asList(f1));
		
		atividadesAvaliativasRepository.saveAll(Arrays.asList(at1));
		
		resultadoFinalRepository.saveAll(Arrays.asList(r1));

	}

	
}