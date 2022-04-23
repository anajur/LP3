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
    
    public Cidade buscarCidadeNome(String nome) {
        Optional<Cidade> obj = repository.buscarCidadeNome(nome); 
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Nome: " + nome + ", Estado"+ CidadeService.class.getName()));
    }
    


}

