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

    @Override
    public Conteudo buscarID(Long id) {
        Optional<Conteudo> conteudo = repositorioConteudo.findById(id);
        if(conteudo.isPresent()){
            return conteudo.get();
        }
        return null;
    }

    public Iterable<Genero> buscarTodosGeneros() {
        return repositorioGenero.findAll();
    }


    public Iterable<Conteudo> buscarTitulo(String title) throws JsonProcessingException {
        ArrayList<Conteudo> conteudo = new ArrayList<>();
        Map<Integer, String> map = new HashMap<Integer, String>();
        Generos generos = servicoClienteTheMoviedbGenero.resultadoGeneroFilmes();
        Generos tv = servicoClienteTheMoviedbGenero.resultadoGeneroTV();
        generos.getGenres().addAll(tv.getGenres());
        for (Genero obj:generos.getGenres()) {
            map.put(obj.getId(), obj.getName());
        }
        ArrayList<Genero> repositorioGeneroAll = (ArrayList<Genero>) repositorioGenero.findAll();
        if(repositorioGeneroAll.size() == 0 || generos.getGenres().size() > repositorioGeneroAll.size()){
            for (Genero obj: generos.getGenres()) {
                if(repositorioGeneroAll.indexOf(obj) < 0){
                    obj.setName(map.get(obj.getId()));
                    repositorioGenero.save(obj);
                }
            }
        }
        Results data = servicoClienteTheMoviedb.conteudoResultado(title);
        for (Conteudo cont: data.getResults()) {
                if(!repositorioConteudo.findById(cont.getId()).isPresent()){
                    conteudo.add(cont);
                    for (Genero gene: cont.getGenre_ids()) {
                        gene.setName(map.get(gene.getId()));
                    }
                    repositorioConteudo.save(cont);
                }
            }
        return conteudo;
    }

    @Override
    public void atualizar(Long id, Conteudo conteudo) {
        Optional<Conteudo> cont = repositorioConteudo.findById(id);
        if(cont.isPresent()){
            repositorioConteudo.save(conteudo);
        }
    }

    @Override
    public void deletar(Long id) {
        repositorioConteudo.deleteById(id);
    }
}
