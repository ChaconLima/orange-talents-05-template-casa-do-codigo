package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroPais.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Deprecated
    public Pais(){}

    public Pais(@NotBlank String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "{ Pais: "+this.nome+" }";
    }
    public Long getId() {
        return id;
    }
}
