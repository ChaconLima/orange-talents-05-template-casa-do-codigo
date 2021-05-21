package br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.ValidacaoCustomizada;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = { UmEstadoPorPaisValidator.class})
@Target({ TYPE })
@Retention(RUNTIME)

public @interface UmEstadoPorPais {
    Class<?> domainClass();
    
    String fieldName();

    String message() default "Já existe um estado cadastrado relacionado com o identificador do país informado";

    Class<?>[] groups() default { };

    Class<? extends Payload >[] payload() default {};

   

    
}
