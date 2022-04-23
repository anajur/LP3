package br.ifsul.dto;

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

    @Column(columnDefinition = "VARCHAR(60)")
    private String titulo;

    @Column(columnDefinition = "VARCHAR(250)")
    private String descricao;

    @Column(precision=10, scale=8)
    private float latitude;

    @Column(precision=10, scale=8)
    private float longitude;

    @JoinColumn(name = "idCidade")
    @ManyToOne
    private Cidade cidade;
}
