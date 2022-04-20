package br.ifsul.dto;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cidade {

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

    public Cidade(Integer idCidade, String nome, String descricao, String estado, String pais, List<PontoTuristico> pontosTuristicos) {
        this.idCidade = idCidade;
        this.nome = nome;
        this.descricao = descricao;
        this.estado = estado;
        this.pais = pais;
        this.pontosTuristicos = pontosTuristicos;
    }

    public Cidade() {
        super();
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<PontoTuristico> getPontosTuristicos() {
        return pontosTuristicos;
    }

    public void setPontosTuristicos(List<PontoTuristico> pontosTuristicos) {
        this.pontosTuristicos = pontosTuristicos;
    }
}
