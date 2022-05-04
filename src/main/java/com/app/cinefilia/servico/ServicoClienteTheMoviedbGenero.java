package com.app.cinefilia.servico;

import com.app.cinefilia.conteudo.Conteudo;
import com.app.cinefilia.conteudo.Genero;
import com.app.cinefilia.conteudo.Generos;
import com.app.cinefilia.conteudo.Results;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "genero", url = "https://api.themoviedb.org/")
public interface ServicoClienteTheMoviedbGenero {

    @GetMapping("3/genre/movie/list?api_key=6360c588c1879ed5fb0171b5beb4528a&language=pt-BR")
    Generos resultadoGeneroFilmes();
    @GetMapping("3/genre/tv/list?api_key=6360c588c1879ed5fb0171b5beb4528a&language=pt-BR")
    Generos resultadoGeneroTV();
}
