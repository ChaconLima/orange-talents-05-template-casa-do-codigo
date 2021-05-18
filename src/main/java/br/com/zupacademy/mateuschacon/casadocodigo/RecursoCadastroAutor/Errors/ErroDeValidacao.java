package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Errors;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCategoria.Errors.ErrorNomaDuplicadoCategoria;

@RestControllerAdvice
public class ErroDeValidacao {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private ErroEmailDuplicadoAutor erroEmailDuplicadoAutor;

    @Autowired
    private ErrorNomaDuplicadoCategoria errorNomaDuplicadoCategoria;
    
    @InitBinder(value = "novoAutorRequest")
    public void init_autor(WebDataBinder webDataBinder){
        webDataBinder.addValidators( this.erroEmailDuplicadoAutor );
    }

    @InitBinder(value = "novaCategoriaRequest")
    public void init_categoria(WebDataBinder webDataBinder){
        webDataBinder.addValidators( this.errorNomaDuplicadoCategoria );
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroNovoAutorRequest> handle( MethodArgumentNotValidException execption) {

        List<ErroNovoAutorRequest> dto = new ArrayList<>();
        List<FieldError> fieldErrors = execption.getBindingResult().getFieldErrors();

        fieldErrors.forEach(e->{

            String mensagem = this.messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroNovoAutorRequest erro  = new ErroNovoAutorRequest(e.getField(), mensagem);

            dto.add(erro);

        });
        return dto;

    }
}

