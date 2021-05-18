package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCategoria.Dtos;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCategoria.Models.Categoria;

public class NovaCategoriaRequest {

    @NotBlank
    private String nome;

    @Deprecated
    public NovaCategoriaRequest() {} 

    public NovaCategoriaRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public Categoria toModel(){
        Categoria categoria = new Categoria(this.nome);
        return categoria;
    }

    public String getNome() {
        return this.nome;
    }
}
