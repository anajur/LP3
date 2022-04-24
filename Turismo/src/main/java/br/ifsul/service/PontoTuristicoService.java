package br.ifsul.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.dto.Cidade;
import br.ifsul.dto.PontoTuristico;
import br.ifsul.repository.CidadeRepository;
import br.ifsul.repository.PontoTuristicoRepository;

import java.util.List;

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

    public List<PontoTuristico> buscarPorCidadeDescricao(int id, String descricao) {
        return repository.buscarPorCidadeDescricao(cidadeRepository.findById(id).get(), descricao);
    }

    public List<PontoTuristico> findByCidade(Integer idCidade) throws Exception {

        return repository.findByCidade(cidadeRepository.findById(idCidade).get());
    }

    public void atribuirNota(Integer id, Double notaAtribuida) throws Exception {
        if(notaAtribuida > 5.0 || notaAtribuida < 0) throw new Exception("A nota deve estar entre 0 e 5");
        repository.findById(id).ifPresent(ponto ->
        {
            Double nota = notaAtribuida;
            if (ponto.getNota() != null) {
                nota = ((ponto.getNota() + notaAtribuida) / 2);
            }
            ponto.setNota(nota);
            repository.save(ponto);
        });
    }
	    public PontoTuristico adicionarPontoTuristico(PontoTuristico pontoturistico) {
	        repository.save(pontoturistico);
			return pontoturistico;
	    }

		public List<PontoTuristico> pesquisaPontosPorGeolocalizacao(float lat, float lgn, double distancia) {
		return	repository.pesquisarPorGeolocalizacao(lat,lgn, distancia);

		}
}

