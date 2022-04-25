package br.ifsul.service;

import java.util.List;
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

    @Autowired
    public CidadeRepository cidadeRepository;

    public PontoTuristico adicionarPontoTuristico(PontoTuristico pontoturistico) {
        repository.save(pontoturistico);
        return pontoturistico;
    }

    public List<PontoTuristico> buscarPorCidadeDescricao(int id, String descricao)  {
        return repository.buscarPorCidadeDescricao(cidadeRepository.findById(id).get(), descricao);
    }
}

