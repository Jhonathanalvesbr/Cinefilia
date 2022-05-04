package com.app.cinefilia.servico;

import com.app.cinefilia.conteudo.Conteudo;
import com.app.cinefilia.conteudo.Titulo;

public interface ServicoConteudoInterface {
    Iterable<Conteudo> buscarTodos();

    void inserir(Titulo titulo);

    void atualizar(Long id);

    void deletar(Long id);
}
