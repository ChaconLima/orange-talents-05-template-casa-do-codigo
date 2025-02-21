package br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.ValidacaoCustomizada;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object>{

    private String domainAttribute;
    private Class<?> klass;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UniqueValue params){
        domainAttribute = params.fieldName();
        klass=params.domainClass();

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
       
        String qlString = "select 1 from "+ this.klass.getName() +" where "+this.domainAttribute+"=:value";
        Query query = this.entityManager.createQuery(qlString);
        query.setParameter("value", value);
        List<?> list = query.getResultList();

        String message = "Foi encontrado mais de uma informação da entidade"+this.klass+" com o atributo "+this.domainAttribute+"="+value;
        Assert.isTrue(list.size() <= 1, message);

        if(list.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

}
