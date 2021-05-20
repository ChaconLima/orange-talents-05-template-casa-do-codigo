package br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.MensagensErrorsPadroes;

import java.util.ArrayList;
import java.util.List;

public class ResponseErrosDto {

    List<ErroRequest> errosValidacao = new ArrayList<>();
    List<String> errosGlobais = new ArrayList<>();


    public void addErrosValidacao( ErroRequest erroRequest){
        this.errosValidacao.add(erroRequest);
    }
    public void addErrosGlobais( String mensagem){
        this.errosGlobais.add(mensagem);
    }

    public List<String> getErrosGlobais() {
        return errosGlobais;
    }
    public List<ErroRequest> getErrosValidacao() {
        return errosValidacao;
    }
}
