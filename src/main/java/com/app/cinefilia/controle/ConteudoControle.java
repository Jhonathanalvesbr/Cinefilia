package com.app.cinefilia.controle;

import com.app.cinefilia.conteudo.Conteudo;
import com.app.cinefilia.conteudo.Genero;
import com.app.cinefilia.conteudo.Titulo;
import com.app.cinefilia.servico.ServicoConteudo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.awt.geom.GeneralPath;

@RestController
@RequestMapping("/api/v1/conteudo")
public class ConteudoControle {
    @Autowired
    private ServicoConteudo servicoConteudo;

    @GetMapping
    public ResponseEntity<Iterable<Conteudo>> buscarTodos(){
        return ResponseEntity.ok(servicoConteudo.buscarTodos());
    }

    @PostMapping
    public Iterable<Conteudo> inserirConteudo(@RequestBody Titulo titulo) throws JsonProcessingException {
        return servicoConteudo.buscarTitulo(titulo.getTitle());
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deletar(@PathVariable long id){
        servicoConteudo.deletar(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public  ResponseEntity<Conteudo> atualizar(@PathVariable long id, @RequestBody Conteudo conteudo){
        servicoConteudo.atualizar(id, conteudo);
        return ResponseEntity.ok(conteudo);
    }
}
