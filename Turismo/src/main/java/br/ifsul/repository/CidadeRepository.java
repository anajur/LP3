package br.ifsul.repository;

import br.ifsul.dto.Cidade;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
	
	Optional<Cidade> buscarCidadeNome(String nome);
	Optional<Cidade> buscaCidadeEstado(String estado);
	Optional<Cidade> buscarCidadePais(String pais);
}
