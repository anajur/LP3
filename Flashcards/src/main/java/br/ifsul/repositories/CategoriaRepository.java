package br.ifsul.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifsul.dto.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
