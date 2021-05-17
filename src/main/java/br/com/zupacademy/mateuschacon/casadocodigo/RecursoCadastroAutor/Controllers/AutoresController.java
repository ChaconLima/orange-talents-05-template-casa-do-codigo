package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Controllers;






import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Dtos.NovoAutorRequest;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Models.Autor;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Repositorys.AutorRepository;

@RestController
@RequestMapping(value = "/api/autores")
public class AutoresController {
    

    @Autowired
    AutorRepository autorRepository;

    @PostMapping
    public String novoCadastro(@RequestBody @Valid NovoAutorRequest novoAutorRequest ){

        Autor autor = novoAutorRequest.toModel();
        this.autorRepository.save(autor);

        return autor.toString();
    }

}
 