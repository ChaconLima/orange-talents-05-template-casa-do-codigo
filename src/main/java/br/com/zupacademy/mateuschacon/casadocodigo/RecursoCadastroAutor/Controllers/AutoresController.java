package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Controllers;




import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Dtos.NovoAutorRequest;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Models.Autor;

@RestController
@RequestMapping(value = "/autores")
public class AutoresController {
    

    @PostMapping
    public String novoCadastro(@RequestBody @Valid NovoAutorRequest novoAutorRequest ){

        Autor autor = novoAutorRequest.toModel();
       
        return autor.toString();
    }

}
 