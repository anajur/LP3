package br.ifsul.repository;

import br.ifsul.dto.Cidade;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
	
	Optional<Cidade> findByNome(String nome);
	Optional<Cidade> findByEstado(String estado);
	Optional<Cidade> findByPais(String pais);
}
