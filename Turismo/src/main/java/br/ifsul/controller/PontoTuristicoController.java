package br.ifsul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifsul.dto.PontoTuristico;
import br.ifsul.service.PontoTuristicoService;

@RestController
@RequestMapping("/pontoturistico")
public class PontoTuristicoController {
    @Autowired
    private PontoTuristicoService service;

    @PostMapping()
    PontoTuristico adicionarPontoTuristico(@RequestBody PontoTuristico pontoturistico) {
        return service.adicionarPontoTuristico(pontoturistico);
    }

}
