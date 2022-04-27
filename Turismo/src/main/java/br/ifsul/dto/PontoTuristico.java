package br.ifsul.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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

    @Column(columnDefinition = "VARCHAR(60)")
    private String titulo;

    @Column(columnDefinition = "VARCHAR(250)")
    private String descricao;

    @Column(precision = 10, scale = 8)
    private float latitude;

    @Column(precision = 10, scale = 8)
    private float longitude;

    private Double nota;

    @NonNull
    @JoinColumn(name = "idCidade")
    @ManyToOne
    @JsonIgnore
    private Cidade cidade;
}
