package br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.MensagensErrorsPadroes;

public class ErroRequest {
    
    private String erro;
    private String mensagem;

    public ErroRequest(String erro, String mensagem) {
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
