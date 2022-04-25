package br.ifsul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.dto.Cidade;
import br.ifsul.dto.PontoTuristico;
import br.ifsul.service.PontoTuristicoService;

import java.util.List;

@RestController
@RequestMapping("/pontoturistico")
public class PontoTuristicoController {
    @Autowired
    private PontoTuristicoService service;

    @PostMapping("/adicionar")
    PontoTuristico adicionarPontoTuristico(@RequestBody PontoTuristico pontoturistico) {
        return service.adicionarPontoTuristico(pontoturistico);
    }

    @GetMapping(value = "/{idCidade}/{descricao}")
    public List<PontoTuristico> buscarPontoTuristico(@PathVariable int idCidade, @PathVariable String descricao) throws Exception {

        return service.buscarPorCidadeDescricao(idCidade, descricao);
    }
  
    
}
