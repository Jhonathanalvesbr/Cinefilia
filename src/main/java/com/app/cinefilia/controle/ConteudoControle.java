package com.app.cinefilia.controle;

import com.app.cinefilia.conteudo.Conteudo;
import com.app.cinefilia.conteudo.Titulo;
import com.app.cinefilia.servico.ServicoConteudo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/api/v1/conteudo")
public class ConteudoControle {
    @Autowired
    private ServicoConteudo servicoConteudo;

    @GetMapping
    public ResponseEntity<Iterable<Conteudo>> buscarTodos(){
        return ResponseEntity.ok(servicoConteudo.buscarTodos());
    }

    @PostMapping()
    public Iterable<Conteudo> inserirConteudo(@RequestBody Titulo titulo) throws JsonProcessingException {
        return servicoConteudo.buscarTitulo(titulo.getTitle());

    }
}
