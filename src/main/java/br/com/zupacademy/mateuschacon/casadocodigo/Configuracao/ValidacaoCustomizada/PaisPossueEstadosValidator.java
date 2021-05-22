package br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.ValidacaoCustomizada;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCliente.Dtos.NovoClienteRequest;

public class PaisPossueEstadosValidator implements ConstraintValidator<PaisPossueEstados,NovoClienteRequest>{

    private Class<?> domainClass;
    private String fildName;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(PaisPossueEstados constraintAnnotation) {
        this.domainClass = constraintAnnotation.domainClass();
        this.fildName = constraintAnnotation.fieldName();
       
    }

    @Override
    public boolean isValid(NovoClienteRequest value, ConstraintValidatorContext context) {
        String qlString = "select 1 from "+this.domainClass.getName()+" m left join m."+this.fildName+" p where m."+this.fildName+"="+value.getIdentificadorPais();
        Query query = this.entityManager.createQuery(qlString);

        List<?> list = query.getResultList();

        if
        (
            (!list.isEmpty() && value.getIdentificadorEstado() != null)  || 
            ( list.isEmpty() && value.getIdentificadorEstado() == null)  || 
            ( list.isEmpty())
        ){
            return true;
        }

        return false;
    }
    
}
