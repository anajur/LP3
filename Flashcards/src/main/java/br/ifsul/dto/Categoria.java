package br.ifsul.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Table(name = "categoria")
@Entity
@ToString(of = { "titulo" })
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 30)
	private String titulo;

	@OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
	private List<Flashcard> flashcards;

}
