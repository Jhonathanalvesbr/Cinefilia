package com.app.cinefilia.servico;

import com.app.cinefilia.conteudo.Conteudo;
import com.app.cinefilia.conteudo.Results;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@FeignClient(name = "themoviedb", url = "https://api.themoviedb.org/3/search/movie/")
public interface ServicoClienteTheMoviedb {


    @GetMapping("?api_key=6360c588c1879ed5fb0171b5beb4528a&language=pt-BR&page=1&include_adult=true&query={title}")
    String conteudoResultado(@PathVariable("title") String title);
}
