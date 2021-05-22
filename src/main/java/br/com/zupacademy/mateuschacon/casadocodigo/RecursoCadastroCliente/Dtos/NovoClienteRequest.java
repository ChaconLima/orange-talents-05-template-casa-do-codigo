package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCliente.Dtos;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.ValidacaoCustomizada.CpfOrCnpj;
import br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.ValidacaoCustomizada.EstadoPertencePais;
import br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.ValidacaoCustomizada.ExisteEntity;
import br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.ValidacaoCustomizada.PaisPossueEstados;
import br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.ValidacaoCustomizada.UniqueValue;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCliente.Models.Cliente;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroEstado.Models.Estado;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroEstado.Repository.EstadoRepository;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroPais.Models.Pais;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroPais.Repository.PaisRepository;

@PaisPossueEstados(domainClass=Estado.class, fieldName="pais")
@EstadoPertencePais(domainClass = Estado.class, fieldName = "id")
public class NovoClienteRequest {
    
    /*--------Declaração dos atributos -----------------
    *
    *
    ---------------------------------------------------*/
    @NotBlank @Email @UniqueValue(domainClass = Cliente.class,fieldName = "email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank @CpfOrCnpj @UniqueValue(domainClass = Cliente.class,fieldName = "documento")
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull @ExisteEntity(domainClass = Pais.class, fieldName = "id")
    private Long identificadorPais;

    private Long identificadorEstado = null;

    @NotBlank @Pattern(regexp="\\(?\\d{2,}\\)?[ -]?\\d{4,}[\\-\\s]?\\d{4}", message = "Formato Errado")
    private String telefone;

    @NotBlank @Pattern(regexp = "\\d\\d\\d\\d\\d-\\d\\d\\d", message = "Formato Errado")
    private String cep;

    /*--------------- Construtor ----------------------
    *
    *
    ---------------------------------------------------*/
    public NovoClienteRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
            @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
            @NotBlank String cidade, @NotNull Long identificadorPais, @NotNull Long identificadorEstado,
            @NotBlank String telefone, @NotBlank String cep) {
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

    /*------------- Metodos Gets ----------------------
    *
    *
    ---------------------------------------------------*/

    public Long getIdentificadorPais() {
        return identificadorPais;
    }
    public Long getIdentificadorEstado() {
        return identificadorEstado;
    }

    /*----- Metodos de Criação da entidade -------------
    *
    *
    ---------------------------------------------------*/
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
