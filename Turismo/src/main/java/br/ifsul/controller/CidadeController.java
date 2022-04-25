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

    @PostMapping("/adicionar")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Cidade adicionarCidade(@RequestBody Cidade cidade) {
       return service.adicionarCidade(cidade);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/{nome}/{estado}/{pais}")
    public Cidade buscarCidadePorNome(@PathVariable String nome, @PathVariable String estado, @PathVariable String pais) throws Exception {
        return service.findByNomeAndEstadoAndPais(nome, estado, pais);
    }
}
