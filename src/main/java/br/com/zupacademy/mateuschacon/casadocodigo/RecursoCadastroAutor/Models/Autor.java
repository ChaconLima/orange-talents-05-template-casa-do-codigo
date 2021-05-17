package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class Autor {

    @NotBlank
    private String nome;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(max = 400)
    private String descricao;
    
    public Autor
    (
        @NotBlank String nome, 
        @NotBlank @Email String email, 
        @NotBlank @Size(max = 400) String descricao
    ){
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }


   
    @Override
    public String toString() {
        return "{nome: '"+this.nome+"' , email:'"+this.email+"' , descricao:'"+this.descricao+"'}";
    }
}
