package br.ifsul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.dto.Cidade;
import br.ifsul.dto.PontoTuristico;
import br.ifsul.repository.CidadeRepository;
import br.ifsul.repository.PontoTuristicoRepository;

@Service
public class PontoTuristicoService {

	@Autowired
	 public PontoTuristicoRepository repository;

	    public PontoTuristico adicionarPontoTuristico(PontoTuristico pontoturistico) {
	        repository.save(pontoturistico);
			return pontoturistico;
	    }
}
