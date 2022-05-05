package com.app.cinefilia.servico;

import com.app.cinefilia.conteudo.Conteudo;
import com.app.cinefilia.conteudo.Titulo;

public interface ServicoConteudoInterface {
    Iterable<Conteudo> buscarTodos();

    Conteudo buscarID(Long id);

    void atualizar(Long id, Conteudo conteudo);

    void deletar(Long id);
}
