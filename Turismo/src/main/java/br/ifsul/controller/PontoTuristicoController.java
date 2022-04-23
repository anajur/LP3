package br.ifsul.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.dto.PontoTuristico;
import br.ifsul.service.PontoTuristicoService;

@RestController
@RequestMapping("/pontoturistico")
public class PontoTuristicoController {
    private PontoTuristicoService service;

    @PostMapping("/adicionar")
    void adicionarPontoTuristico(@RequestBody PontoTuristico pontoturistico) {
        service.adicionarPontoTuristico(pontoturistico);
    }

}
