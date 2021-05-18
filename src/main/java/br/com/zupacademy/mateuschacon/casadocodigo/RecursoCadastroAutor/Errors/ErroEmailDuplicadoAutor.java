package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Errors;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Dtos.NovoAutorRequest;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Models.Autor;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Repositorys.AutorRepository;

@Component
public class ErroEmailDuplicadoAutor implements Validator{

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoAutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        NovoAutorRequest novoAutorRequest =(NovoAutorRequest) target;
        Optional<Autor> autor = autorRepository.findByEmail(novoAutorRequest.getEmail());
        
        if(autor.isPresent()){
            errors.rejectValue("email", null ,"O e-mail: "+novoAutorRequest.getEmail()+ ". Já está cadastrado!");
        }
    }
}
