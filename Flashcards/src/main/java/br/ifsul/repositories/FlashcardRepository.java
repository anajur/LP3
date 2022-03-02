package br.ifsul.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.dto.Categoria;
import br.ifsul.dto.Flashcard;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {

	List<Flashcard> findByCategoria(Categoria categoria);

}
