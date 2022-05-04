package com.app.cinefilia.servico;

import com.app.cinefilia.conteudo.*;
import com.app.cinefilia.repositorio.RepositorioConteudo;
import com.app.cinefilia.repositorio.RepositorioGenero;
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
    @Autowired
    ServicoClienteTheMoviedbGenero servicoClienteTheMoviedbGenero;
    @Autowired
    RepositorioGenero repositorioGenero;

    @Override
    public Iterable<Conteudo> buscarTodos() {
        return repositorioConteudo.findAll();
    }

    public Iterable<Genero> buscarTodosGeneros() {
        return repositorioGenero.findAll();
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
        Generos generos = servicoClienteTheMoviedbGenero.resultadoGeneroFilmes();
        Generos tv = servicoClienteTheMoviedbGenero.resultadoGeneroTV();
        for (Genero obj:tv.getGenres()
             ) {
            generos.getGenres().add(obj);
        }
        ArrayList<Genero> repositorioGeneroAll = (ArrayList<Genero>) repositorioGenero.findAll();
        if(repositorioGeneroAll.size() == 0 || generos.getGenres().size() > repositorioGeneroAll.size()){
            for (Genero obj: generos.getGenres()) {
                if(repositorioGeneroAll.indexOf(obj) < 0){
                    for (Genero id:generos.getGenres()
                    ) {

                    }
                    obj.setName(generos.getGenres().get());
                    repositorioGenero.save(obj);
                    System.out.println(obj);
                }
            }
        }
        for (Conteudo titulo:conteudos
             ) {
            if(titulo.getTitle().equals(title)){
                conteudo.add(titulo);
            }
        }

        Results data = servicoClienteTheMoviedb.conteudoResultado(title);
        for (Conteudo cont: data.getResults()) {
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
