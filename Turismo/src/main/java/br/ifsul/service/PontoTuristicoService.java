package br.ifsul.service;

import org.springframework.stereotype.Service;

import br.ifsul.dto.Cidade;
import br.ifsul.dto.PontoTuristico;
import br.ifsul.repository.CidadeRepository;
import br.ifsul.repository.PontoTuristicoRepository;

@Service
public class PontoTuristicoService {

	
	 public PontoTuristicoRepository repository;

	    public void adicionarPontoTuristico(PontoTuristico pontoturistico) {
	        repository.save(pontoturistico);
	    }
}
