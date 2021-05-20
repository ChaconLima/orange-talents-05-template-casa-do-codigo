package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroLivro.Dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.ValidacaoCustomizada.ExisteEntity;
import br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.ValidacaoCustomizada.MinimumValue;
import br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.ValidacaoCustomizada.UniqueValue;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Models.Autor;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Repositorys.AutorRepository;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCategoria.Models.Categoria;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCategoria.Repository.CategoriaRepository;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroLivro.Models.Livro;

public class NovoLivroRequest {
    @NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank @Size(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull @MinimumValue(minimun = "20.00")
    private BigDecimal preco;

    @NotNull @MinimumValue(minimun = "100")
    private Integer quantidadePaginas;

    @NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @Future @JsonFormat(pattern = "dd/MM/yyyy",shape = Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull @ExisteEntity(domainClass = Autor.class, fieldName = "id")
    private Long identificadorAutor;

    @NotNull @ExisteEntity(domainClass = Categoria.class, fieldName = "id")
    private Long identificadorCategoria;

    public NovoLivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
            @NotNull BigDecimal preco, @NotNull Integer quantidadePaginas, @NotBlank String isbn
            , @NotNull Long identificadorAutor, @NotNull Long identificadorCategoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.quantidadePaginas = quantidadePaginas;
        this.isbn = isbn;
        // this.dataPublicacao = dataPublicacao;
        this.identificadorAutor = identificadorAutor;
        this.identificadorCategoria = identificadorCategoria;
    }

    public void setDataPublicacao(LocalDate dataPublicacao){
        this.dataPublicacao = dataPublicacao;
    }

    public Livro toModel(AutorRepository autorRepository, CategoriaRepository categoriaRepository){
        
        Optional<Autor>autor = autorRepository.findById(this.identificadorAutor);
        Optional<Categoria>categoria = categoriaRepository.findById(this.identificadorCategoria);
    
        Livro livro = new Livro
        ( 
            this.titulo, 
            this.resumo ,
            this.sumario,  
            this.preco,
            this.quantidadePaginas,
            this.isbn,
            this.dataPublicacao,
            autor.get(),
            categoria.get()
        );
        return livro;
    }
}


