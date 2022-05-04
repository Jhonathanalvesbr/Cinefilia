package com.app.cinefilia.conteudo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Conteudo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private boolean adult;
    private String backdrop_path;

    @ManyToMany
    private List<Genero> genre_ids;
    private String original_language;
    private String original_title;
    @Column(length=1000000)
    @Lob
    private String overview;
    private double popularity;
    private String poster_path;
    private String release_date;
    private String title;
    private boolean video;
    private long vote_average;
    private long vote_count;
}
