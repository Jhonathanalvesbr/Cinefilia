package com.app.cinefilia.conteudo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class Results {
    int page;
    public List<Conteudo> results;
    public int total_pages;
    public int total_results;
}
