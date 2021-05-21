package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroEstado.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroPais.Models.Pais;

@Entity
public class Estado {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;
    
    @ManyToOne @NotNull
    private Pais pais;

    public Estado(@NotBlank String nome, @NotNull Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    @Override
    public String toString() {
       
        return "{ Estado: "+this.nome+" }";
    }
}
