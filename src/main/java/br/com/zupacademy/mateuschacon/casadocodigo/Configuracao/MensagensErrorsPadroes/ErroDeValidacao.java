package br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.MensagensErrorsPadroes;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroDeValidacao {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroRequest> handle( MethodArgumentNotValidException execption) {

        List<ErroRequest> dto = new ArrayList<>();
        List<FieldError> fieldErrors = execption.getBindingResult().getFieldErrors();

        fieldErrors.forEach(e->{

            String mensagem = this.messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroRequest erro  = new ErroRequest(e.getField(), mensagem);

            dto.add(erro);

        });
        return dto;

    }
}

