package com.app.cinefilia.conteudo;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class Conteudo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private boolean adult;
    private String backdropPath;
    @ManyToOne
    private Long genreIds;
    private String originalLanguage;
    private String originalTitle;
    @Column(length=1000000)
    @Lob
    private String overview;
    private double popularity;
    private String posterPath;
    private String releaseDate;
    private String title;
    private boolean video;
    private long voteAverage;
    private long voteCount;
}
