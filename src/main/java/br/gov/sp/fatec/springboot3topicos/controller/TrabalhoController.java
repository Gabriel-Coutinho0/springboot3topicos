package br.gov.sp.fatec.springboot3topicos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springboot3topicos.entity.Trabalho;
import br.gov.sp.fatec.springboot3topicos.service.TrabalhoService;

@RestController
@RequestMapping(value = "/trabalho")
@CrossOrigin
public class TrabalhoController {
    
    @Autowired
    private TrabalhoService service;

    @GetMapping
    public List<Trabalho> buscarTodosTrabalhos(@RequestParam String titulo,@RequestParam Integer nota){
        return service.buscarTodosTrabalhos(titulo,nota);
    }

    @PostMapping
    public Trabalho cadastrarNovoTrabalho(@RequestBody Trabalho trabalho){
        return service.cadastrarTrabalho(trabalho);
    }
    @GetMapping(value = "/{id}")
    public Trabalho buscarUsuarioPorId(@PathVariable("id") Long id) {
        return service.buscarTrabalhoPorId(id);
    }
}
