package br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.ValidacaoCustomizada;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.TYPE;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {PaisPossueEstadosValidator.class})
@Target({ TYPE })
@Retention(RUNTIME)
public @interface PaisPossueEstados {

    Class<?> domainClass();

    String message() default "O identificador do País possui Estados vinculados";

    Class<?>[] groups() default { };

    Class<? extends Payload >[] payload() default {};

    String fieldName();

}
