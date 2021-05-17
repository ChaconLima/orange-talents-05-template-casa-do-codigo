package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Errors;

public class ErroNovoAutorRequest {
    
    private String erro;
    private String mensagem;

    public ErroNovoAutorRequest(String erro, String mensagem) {
        this.erro = erro;
        this.mensagem = mensagem;
    }

    public String getErro() {
        return erro;
    }

    public String getMensagem() {
        return mensagem;
    }
}
