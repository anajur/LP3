package br.ifsul.dto;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "pontoTuristico")
public class PontoTuristico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(60)")
    private String titulo;

    @Column(columnDefinition = "VARCHAR(250)")
    private String descricao;
    @Column(precision=10, scale=8)
    @Type(type = "big_decimal")
    private float latitude;
    @Column(precision=10, scale=8)
    @Type(type = "big_decimal")
    private float longitude;

    @JoinColumn(name = "idCidade")
    @ManyToOne
    private Cidade cidade;

    public PontoTuristico(Integer id, String titulo, String descricao, float latitude, float longitude, Cidade cidade) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cidade = cidade;
    }

    public PontoTuristico() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
