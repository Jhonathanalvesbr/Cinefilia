package com.app.cinefilia.servico;

import com.app.cinefilia.conteudo.Genero;
import com.app.cinefilia.conteudo.Results;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "themoviedb", url = "https://api.themoviedb.org/3/search/movie/")
public interface ServicoClienteTheMoviedb {

    @GetMapping("?api_key=6360c588c1879ed5fb0171b5beb4528a&language=pt-BR&page=1&include_adult=true&query={title}")
    Results conteudoResultado(@PathVariable("title") String title);
}
