package com.app.cinefilia.repositorio;

import com.app.cinefilia.conteudo.Conteudo;
import com.app.cinefilia.conteudo.Genero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioGenero extends CrudRepository<Genero, Long> {

}
