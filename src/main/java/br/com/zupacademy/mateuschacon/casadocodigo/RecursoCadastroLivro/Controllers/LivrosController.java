package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroLivro.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Repositorys.AutorRepository;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCategoria.Repository.CategoriaRepository;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroLivro.Dtos.NovoLivroRequest;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroLivro.Models.Livro;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroLivro.Repository.LivroRepository;

@RestController
@RequestMapping(value = "/api/livros")
public class LivrosController {
    
    @Autowired
    AutorRepository autorRepository;
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    LivroRepository livroRepository;

    @PostMapping
    public String cadastroNovoLivro(@RequestBody @Valid NovoLivroRequest novoLivroRequest){

        Livro livro = novoLivroRequest.toModel(this.autorRepository, this.categoriaRepository);
        this.livroRepository.save(livro);

        return livro.toString();
    }
}
