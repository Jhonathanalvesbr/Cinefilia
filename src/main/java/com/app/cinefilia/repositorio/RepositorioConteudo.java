package com.app.cinefilia.repositorio;

import com.app.cinefilia.conteudo.Conteudo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioConteudo extends CrudRepository<Conteudo, Long> {

}
