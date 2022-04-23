package br.ifsul.service;

import br.ifsul.dto.Cidade;
import br.ifsul.repository.CidadeRepository;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repository;

    public Cidade adicionarCidade(Cidade cidade) {
        repository.save(cidade);
        return cidade;
    }
    
    public Cidade findByNomeAndEstadoAndPais(String nome, String estado, String pais) throws Exception {
        Optional<Cidade> obj = repository.findByNomeAndEstadoAndPais(nome, estado, pais); 
        return obj.orElseThrow(() -> new Exception("Cidade não encontrada! Nome: " + nome ));
    }
    


}

