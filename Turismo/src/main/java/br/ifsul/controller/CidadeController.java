package br.ifsul.controller;

import br.ifsul.dto.Cidade;
import br.ifsul.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cidade")
public class CidadeController {
    @Autowired
    private CidadeService service;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    Cidade adicionarCidade(@RequestBody Cidade cidade) {
        return service.adicionarCidade(cidade);
    }

}
