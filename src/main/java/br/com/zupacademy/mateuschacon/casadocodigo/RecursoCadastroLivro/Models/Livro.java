package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroLivro.Models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Models.Autor;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCategoria.Models.Categoria;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank @Size(max = 500)
    private String resumo;

    @NotBlank @Lob @Column( columnDefinition = "TINYTEXT")
    private String sumario;

    @NotNull
    private BigDecimal preco;

    @NotNull
    private Integer quantidadePaginas;

    @NotBlank
    private String isbn;

    @Future
    private LocalDate dataPublicacao;

    @ManyToOne
    private Autor autor;

    @ManyToOne
    private Categoria categoria;

    @Deprecated
    public Livro(){}

    public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
            @NotNull BigDecimal preco, @NotNull Integer quantidadePaginas, @NotBlank String isbn,
            @Future LocalDate dataPublicacao, Autor autor, Categoria categoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.quantidadePaginas = quantidadePaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "{livro: [ titulo:"+ this.titulo+" , Isbn:"+this.isbn+"] }";
    }

    public Long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
}
