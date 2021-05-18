package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCategoria.Errors;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCategoria.Models.Categoria;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCategoria.Dtos.NovaCategoriaRequest;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCategoria.Repository.CategoriaRepository;

@Component
public class ErrorNomaDuplicadoCategoria implements Validator{

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCategoriaRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        NovaCategoriaRequest novaCategoriaRequest = (NovaCategoriaRequest) target;
        Optional<Categoria> categoria = this.categoriaRepository.findByNome(novaCategoriaRequest.getNome()); 
        
        if(categoria.isPresent()){
            errors.rejectValue( "nome", null, "Categoria:"+novaCategoriaRequest.getNome()+" já cadastrada !!");
        }
    }
    
}
