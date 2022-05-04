package com.app.cinefilia.servico;

import com.app.cinefilia.conteudo.Conteudo;
import com.app.cinefilia.conteudo.Results;
import com.app.cinefilia.conteudo.Titulo;
import com.app.cinefilia.repositorio.RepositorioConteudo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServicoConteudo implements ServicoConteudoInterface{
    @Autowired
    RepositorioConteudo repositorioConteudo;
    @Autowired
    ServicoClienteTheMoviedb servicoClienteTheMoviedb;

    @Override
    public Iterable<Conteudo> buscarTodos() {
        return repositorioConteudo.findAll();
    }

    @Override
    public void inserir(Titulo titulo) {
        try {
            buscarTitulo(titulo.getTitle());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


    public Iterable<Conteudo> buscarTitulo(String title) throws JsonProcessingException {
        ArrayList<Conteudo> conteudos = (ArrayList<Conteudo>) repositorioConteudo.findAll();
        ArrayList<Conteudo> conteudo = new ArrayList<>();
        for (Conteudo titulo:conteudos
             ) {
            if(titulo.getTitle().equals(title)){
                conteudo.add(titulo);
            }
        }
        String conteudoResultado =  servicoClienteTheMoviedb.conteudoResultado(title);
        Results data = new Gson().fromJson(conteudoResultado, Results.class);
        for (Conteudo cont: data.getResults()        ) {
                if(conteudo.indexOf(cont) == -1){
                    conteudo.add(cont);
                    repositorioConteudo.save(cont);
                }
            }
        return conteudo;
    }

    @Override
    public void atualizar(Long id) {

    }

    @Override
    public void deletar(Long id) {

    }
}
