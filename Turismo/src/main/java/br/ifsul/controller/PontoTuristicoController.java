package br.ifsul.controller;

import br.ifsul.dto.AtribuirNotaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(code = HttpStatus.CREATED)
    PontoTuristico adicionarPontoTuristico(@RequestBody PontoTuristico pontoturistico) {
        return service.adicionarPontoTuristico(pontoturistico);
    }

    @GetMapping(value = "/{idCidade}/{descricao}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<PontoTuristico> buscarPontoTuristico(@PathVariable int idCidade, @PathVariable String descricao) throws Exception {

        return service.buscarPorCidadeDescricao(idCidade, descricao);
    }

    @GetMapping(value = "/listar/{idCidade}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<PontoTuristico> buscarPontoTuristicoCidade(@PathVariable Integer idCidade) throws Exception {
        return service.findByCidade(idCidade);
    }

    @PutMapping(value = "/nota")
    void atribuirNota(@RequestBody AtribuirNotaRequest request) throws Exception {
        service.atribuirNota(request.getId(), request.getNota());
    }

    @GetMapping("")
    List<PontoTuristico> pesquisaPontosPorGeolocalizacao(@RequestParam Float latitude, @RequestParam Float
            longitude, @RequestParam Double distancia) {
        return service.pesquisaPontosPorGeolocalizacao(latitude, longitude, distancia);
    }
}
