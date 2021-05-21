package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroLivro.Controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Repositorys.AutorRepository;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCategoria.Repository.CategoriaRepository;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroLivro.Dtos.DetalheLivro;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroLivro.Dtos.LivroResponse;
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

    @GetMapping
    public List<LivroResponse> listarLivros(){

        List<Livro> listaDeLivros = (List<Livro>) this.livroRepository.findAll();

        return LivroResponse.converterParaListaDeLivrosResponse(listaDeLivros);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DetalheLivro> detalhamentoDoLivro(@PathVariable("id") long identificadorLivro){
        System.out.println(identificadorLivro);
        Optional<Livro> livro = this.livroRepository.findById(identificadorLivro);
        
        if(livro.isPresent()){
            return ResponseEntity.ok(new DetalheLivro(livro.get()));
        }

        return ResponseEntity.notFound().build();
        
    }
}
