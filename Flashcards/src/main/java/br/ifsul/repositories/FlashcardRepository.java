package br.ifsul.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.dto.Flashcard;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long>{

}
