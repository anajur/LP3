package br.ifsul.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.dto.Cidade;
import br.ifsul.dto.PontoTuristico;


public interface PontoTuristicoRepository extends JpaRepository<PontoTuristico, Integer> {

	Optional<PontoTuristico> findByCidadeAndDescricao(Cidade cidade, String descricao);
}
