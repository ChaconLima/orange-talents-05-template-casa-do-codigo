package br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.MensagensErrorsPadroes;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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
    public ResponseErrosDto handle( MethodArgumentNotValidException execption) {

        List<FieldError> fieldErrors = execption.getBindingResult().getFieldErrors();
        List<ObjectError> globalErrors = execption.getBindingResult().getGlobalErrors();

        return buildValidationError(fieldErrors,globalErrors);

    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseErrosDto handleException(HttpMessageNotReadableException execption) {
        
        String param= (String) execption.getMessage().subSequence(execption.getMessage().lastIndexOf("[")+1,execption.getMessage().lastIndexOf("]"));
        String mensagem = "Formato Errado";

        ResponseErrosDto errosDto = new ResponseErrosDto();
        ErroRequest erro  = new ErroRequest( param , mensagem);
        errosDto.addErrosValidacao(erro);
        
        return errosDto;
    }

    private ResponseErrosDto buildValidationError(List<FieldError> fieldErrors, List<ObjectError> globalErrors) {
        ResponseErrosDto errosDto = new ResponseErrosDto();

        globalErrors.forEach(e->{
            String mensagem = this.messageSource.getMessage(e, LocaleContextHolder.getLocale());
            errosDto.addErrosGlobais(mensagem);
        });

        fieldErrors.forEach(e->{
            String mensagem = this.messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroRequest erro  = new ErroRequest(e.getField(), mensagem);

            errosDto.addErrosValidacao(erro);
        });

        return errosDto;
    }


   


}

