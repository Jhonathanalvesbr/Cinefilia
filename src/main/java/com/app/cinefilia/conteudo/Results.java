package com.app.cinefilia.conteudo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class Results {
    private int page;
    private List<Conteudo> results;
    private int total_pages;
    private int total_results;
}
