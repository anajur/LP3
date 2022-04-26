package br.ifsul.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AtribuirNotaRequest {

    @NotNull
    private Integer id;

    @NotNull
    private Double nota;
}
