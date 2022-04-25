package br.ifsul.service;

import br.ifsul.dto.Cidade;
import br.ifsul.repository.CidadeRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CidadeService {
    @Autowired
    private CidadeRepository repository;

    public Cidade adicionarCidade(Cidade cidade) {

        repository.findByNomeAndEstadoAndPais(cidade.getNome(), cidade.getEstado(), cidade.getPais())
                .ifPresent(acao -> {
                    try {
                        throw new Exception("Cidade já cadastrada.");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

        repository.save(cidade);
        return cidade;
    }

    public Cidade findByNomeAndEstadoAndPais(String nome, String estado, String pais) throws Exception {
        Optional<Cidade> obj = repository.findByNomeAndEstadoAndPais(nome, estado, pais);
        return obj.orElseThrow(() -> new Exception("Cidade não encontrada! Nome: " + nome));
    }


}

