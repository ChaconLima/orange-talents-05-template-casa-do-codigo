package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Models;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotBlank
    private String nome;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(max = 400)
    private String descricao;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    
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

    @Deprecated
    public Autor(){}

    public UUID getId(){
        return this.id;
    } 
   
    @Override
    public String toString() {
        return "{nome: '"+this.nome+"' , email:'"+this.email+"' , descricao:'"+this.descricao+"'}";
    }
}
