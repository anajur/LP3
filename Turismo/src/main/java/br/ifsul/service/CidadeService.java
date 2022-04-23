package br.ifsul.service;

import br.ifsul.dto.Cidade;
import br.ifsul.repository.CidadeRepository;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    public CidadeRepository repository;

    public void adicionarCidade(Cidade cidade) {
        repository.save(cidade);
    }
}
