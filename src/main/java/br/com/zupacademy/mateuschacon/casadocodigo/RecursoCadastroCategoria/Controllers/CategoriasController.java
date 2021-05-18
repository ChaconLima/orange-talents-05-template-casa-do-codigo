package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCategoria.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCategoria.Dtos.NovaCategoriaRequest;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCategoria.Models.Categoria;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCategoria.Repository.CategoriaRepository;

@RestController
@RequestMapping(value = "/api/categorias")
public class CategoriasController {


    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping
    public String cadastro(@RequestBody @Valid NovaCategoriaRequest novaCategoriaRequest){
        
        Categoria categoria = novaCategoriaRequest.toModel();
        this.categoriaRepository.save(categoria);

        return categoria.toString();
    }

}
