package br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.ValidacaoCustomizada;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.FIELD;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {MinimunValueValidator.class })
@Target({ FIELD })
@Retention(RUNTIME)
public @interface MinimumValue {

   
    String message() default "No número informado está abaixo";

    Class<?>[] groups() default { };

    Class<? extends Payload >[] payload() default {};

    String minimun();

    
    
    
}
