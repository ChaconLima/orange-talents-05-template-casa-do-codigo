package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroLivro.Dtos;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Dtos.DetalheAutor;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroLivro.Models.Livro;

public class DetalheLivro {

    @NotBlank
    private String titulo;

    @NotBlank
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull
    private DetalheAutor autor;

    @NotNull
    private Integer numeroPaginas;

    @NotBlank
    private String isbn;

    @NotNull
    private BigDecimal preco;

    public DetalheLivro(Livro livro){
        this.titulo=livro.getTitulo();
        this.resumo=livro.getResumo();
        this.sumario=livro.getSumario();
        this.autor=  new DetalheAutor(livro.getAutor());
        this.numeroPaginas=livro.getQuantidadePaginas();
        this.isbn=livro.getIsbn();
        this.preco = livro.getPreco();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public DetalheAutor getAutor() {
        return autor;
    }
    
    public String getIsbn() {
        return isbn;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}
