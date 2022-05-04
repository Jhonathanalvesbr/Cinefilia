package com.app.cinefilia.conteudo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Genero {
    @Id
    private int id;
    private String name;

    public Genero(int id) {
        this.id = id;
    }
    public Genero(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Genero(String name) {
        this.name = name;
    }
}
