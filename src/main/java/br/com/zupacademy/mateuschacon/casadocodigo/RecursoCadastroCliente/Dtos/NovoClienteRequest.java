package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCliente.Dtos;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.ValidacaoCustomizada.ExisteEstadoEmPais;
import br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.ValidacaoCustomizada.UniqueValue;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCliente.Models.Cliente;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroEstado.Models.Estado;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroEstado.Repository.EstadoRepository;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroPais.Models.Pais;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroPais.Repository.PaisRepository;

// @ExisteEstadoEmPais()
public class NovoClienteRequest {
    
    @NotBlank @Email @UniqueValue(domainClass = Cliente.class,fieldName = "email")
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

    @NotNull
    private Long identificadorPais;

    private Long identificadorEstado = null;

    @NotBlank
    private String telefone;

    @NotNull
    private Long cep;

    public NovoClienteRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
            @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
            @NotBlank String cidade, @NotNull Long identificadorPais, @NotNull Long identificadorEstado,
            @NotBlank String telefone, @NotNull Long cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.identificadorPais = identificadorPais;
        this.identificadorEstado = identificadorEstado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente toModel(EstadoRepository estadoRepository, PaisRepository paisRepository) {

        if(this.identificadorEstado!=null){

            Optional<Estado> estado = estadoRepository.findById(this.identificadorEstado);
            return this.newCliente(estado.get(), estado.get().getPais());
           
        }else{

            Optional<Pais> pais = paisRepository.findById(this.identificadorPais);
            return this.newCliente( null , pais.get());
        }
        
    }

    private Cliente newCliente(Estado estado, Pais pais){
        return new Cliente
        (
            this.email, 
            this.nome, 
            this.sobrenome, 
            this.documento, 
            this.endereco, 
            this.complemento, 
            this.cidade, 
            pais,
            estado, 
            this.telefone, 
            this.cep
        );
    }




}
