package br.com.softbank.relatorios.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.softbank.relatorios.dto.ClubesDTO;

@Service
public class ClubesService {
	
	public List<ClubesDTO> findAll(){
		return Arrays.asList(
				new ClubesDTO("América-MG", "MG", "Arena Independência"),
				new ClubesDTO("Athletico", "PR", "Arena da Baixada"),
				new ClubesDTO("Atlético-GO", "GO", "Antônio Accioly"),
				new ClubesDTO("Atlético-MG", "MG", "Arena Independência"),
				new ClubesDTO("Avaí", "SC", "Estádio da Ressacada"),
				new ClubesDTO("Botafogo", "RJ", "Nilton Santos"),
				new ClubesDTO("Bragantino", "SP", "Estádio Nabi Abi Chedid"),
				new ClubesDTO("Ceará", "CE", "Arena Castelão"),
				new ClubesDTO("Corinthians", "SP", "Neo Química Arena"),
				new ClubesDTO("Coritiba", "PR", "Couto Pereira"),
				new ClubesDTO("Cuiabá", "MT", "Arena Pantanal"),
				new ClubesDTO("Flamengo", "RJ", "Maracanã"),
				new ClubesDTO("Fluminense", "RJ", "Maracanã"),
				new ClubesDTO("Fortaleza", "CE", "Arena Castelão"),
				new ClubesDTO("Goiás", "GO", " Serra Dourada"),
				new ClubesDTO("Juventude", "RS", "Alfredo Jaconi"),
				new ClubesDTO("Internacional", "RS", "Beira-Rio"),
				new ClubesDTO("Palmeiras", "SP", "Allianz Parque"),
				new ClubesDTO("Santos", "SP", "Vila Belmiro"),
				new ClubesDTO("São Paulo", "SP", "Morumbi"));
	}

}
