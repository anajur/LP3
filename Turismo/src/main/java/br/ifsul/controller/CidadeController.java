package br.ifsul.controller;

import br.ifsul.dto.Cidade;
import br.ifsul.service.CidadeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turismo")
public class CidadeController {
    private CidadeService service;

    @PostMapping("/adicionar")
    void adicionarCidade(@RequestBody Cidade cidade) {
        service.adicionarCidade(cidade);
    }

}
