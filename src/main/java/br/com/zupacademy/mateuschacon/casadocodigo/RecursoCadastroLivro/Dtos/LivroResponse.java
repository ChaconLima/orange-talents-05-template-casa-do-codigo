package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroLivro.Dtos;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroLivro.Models.Livro;

public class LivroResponse {
    
    private Long id;
    private String titulo;

    public LivroResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }

    public static List<LivroResponse> converterParaListaDeLivrosResponse( List<Livro> listaDeLivros){
        return listaDeLivros.stream().map(LivroResponse::new).collect(Collectors.toList());
    }

}
