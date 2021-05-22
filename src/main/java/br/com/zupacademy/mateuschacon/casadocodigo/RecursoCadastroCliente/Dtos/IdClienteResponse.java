package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCliente.Dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class IdClienteResponse {
    
    @NotNull private Long id;
    @NotBlank private String mensagem;

    public IdClienteResponse(@NotNull Long id, @NotBlank String mensagem) {
        this.id = id;
        this.mensagem = mensagem;
    }

    public Long getId() {
        return id;
    }
    public String getMensagem() {
        return mensagem;
    }
}
