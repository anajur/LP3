package br.ifsul.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.dto.Cidade;
import br.ifsul.dto.PontoTuristico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


	public interface PontoTuristicoRepository extends JpaRepository<PontoTuristico, Integer> {

	@Query(value = "select p from PontoTuristico p where p.cidade=?1 and p.descricao LIKE CONCAT('%', ?2, '%')")
	List<PontoTuristico> buscarPorCidadeDescricao(Cidade cidade, String descricao);

}
