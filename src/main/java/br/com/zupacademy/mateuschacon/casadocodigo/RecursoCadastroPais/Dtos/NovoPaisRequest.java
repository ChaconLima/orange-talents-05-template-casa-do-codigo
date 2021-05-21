package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroPais.Dtos;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.ValidacaoCustomizada.UniqueValue;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroPais.Models.Pais;

public class NovoPaisRequest {
    
    @NotBlank @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais toModel(){
        return new Pais(this.nome);
    }

}
