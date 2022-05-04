package com.app.cinefilia.conteudo;

import javax.persistence.*;

@Entity
public class Long {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    @JoinColumn(name = "genre_ids_id")
    private Long genreIds;

    public Long getGenreIds() {
        return genreIds;
    }
}
