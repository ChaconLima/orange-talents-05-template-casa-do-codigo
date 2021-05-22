package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCliente.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroEstado.Models.Estado;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroPais.Models.Pais;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull @ManyToOne
    private Pais pais;

    @ManyToOne
    private Estado estado;

    @NotBlank
    private String telefone;

    @NotNull
    private Long cep;


    @Deprecated
    public Cliente(){}

    public Cliente(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
            @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
            @NotBlank String cidade, @NotNull Pais pais, Estado estado, @NotBlank String telefone, @NotNull Long cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

}
