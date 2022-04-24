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

	List<PontoTuristico> findByCidade(Cidade cidade);

	Optional<PontoTuristico>findById(Integer id);

    String HAVERSINE_FORMULA = "(6371.0088 * acos(cos(radians(:latitude)) * cos(radians(s.latitude)) *" +
            " cos(radians(s.longitude) - radians(:longitude)) + sin(radians(:latitude)) * sin(radians(s.latitude))))";

    @Query("SELECT s FROM PontoTuristico s WHERE " + HAVERSINE_FORMULA + " < :distanciaMaxima ORDER BY "+ HAVERSINE_FORMULA + " DESC")
    List<PontoTuristico> pesquisarPorGeolocalizacao(@Param("latitude") float latitude, @Param("longitude") float longitude, @Param("distanciaMaxima") double distancia);

}
