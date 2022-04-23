package br.ifsul.service;

import java.util.Optional;

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
	    
	    public PontoTuristico findByCidadeAndDescricao(Cidade cidade, String descricao) throws Exception {
	        Optional<PontoTuristico> obj = repository.findByCidadeAndDescricao(cidade, descricao);  
	        return obj.orElseThrow(() -> new Exception("Ponto Turístico não encontrado! " ));
	    }
}

