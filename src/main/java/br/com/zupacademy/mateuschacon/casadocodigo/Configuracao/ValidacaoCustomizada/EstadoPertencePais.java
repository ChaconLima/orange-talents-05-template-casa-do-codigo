package br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.ValidacaoCustomizada;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.TYPE;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {EstadoPertencePaisValidator.class})
@Target({ TYPE })
@Retention(RUNTIME)
public @interface EstadoPertencePais {

    Class<?> domainClass();

    String fieldName();

    String message() default "Os identificadores de Estado e Pais, não são de registros relacionados";

    Class<?>[] groups() default { };

    Class<? extends Payload >[] payload() default {};
}
