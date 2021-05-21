package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroEstado.Dtos;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.ValidacaoCustomizada.ExisteEntity;
import br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.ValidacaoCustomizada.UmEstadoPorPais;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroEstado.Models.Estado;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroPais.Models.Pais;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroPais.Repository.PaisRepository;

@UmEstadoPorPais(domainClass = Estado.class, fieldName = "pais")
public class NovoEstadoRequest {
    
    @NotBlank
    private String nome;

    @NotNull @ExisteEntity(domainClass = Pais.class, fieldName = "id")
    private Long identificadorPais;

    public NovoEstadoRequest(@NotBlank String nome, @NotNull Long identificadorPais) {
        this.nome = nome;
        this.identificadorPais = identificadorPais;
    }

    public Estado toModel(PaisRepository paisRepository){

        Optional<Pais> pais = paisRepository.findById(this.identificadorPais);
        
        return new Estado(this.nome, pais.get());
    }

    public Long getIdentificadorPais() {
        return identificadorPais;
    }
    public String getNome() {
        return nome;
    }
}
