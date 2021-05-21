package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Dtos;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Models.Autor;

public class DetalheAutor {
    
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;

    public DetalheAutor( Autor autor){
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }
}
