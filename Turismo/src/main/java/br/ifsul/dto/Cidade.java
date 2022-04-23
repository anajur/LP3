package br.ifsul.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cidade implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCidade")
    private Integer idCidade;

    @Column(columnDefinition = "VARCHAR(60)")
    private String nome;

    @Column(columnDefinition = "VARCHAR(250)")
    private String descricao;

    @Column(columnDefinition = "VARCHAR(60)")
    private String estado;

    @Column(columnDefinition = "VARCHAR(60)")
    private String pais;

    @OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY)
    private List<PontoTuristico> pontosTuristicos;
}
