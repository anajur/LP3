package br.ifsul.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pontoTuristico")
public class PontoTuristico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(columnDefinition = "VARCHAR(60)")
    private String titulo;

    @NotNull
    @Column(columnDefinition = "VARCHAR(250)")
    private String descricao;

    @NotNull
    @Column(precision=10, scale=8)
    private float latitude;

    @NotNull
    @Column(precision=10, scale=8)
    private float longitude;

    private Double nota;

    @JoinColumn(name = "idCidade")
    @ManyToOne
    @JsonIgnore
    private Cidade cidade;
}
