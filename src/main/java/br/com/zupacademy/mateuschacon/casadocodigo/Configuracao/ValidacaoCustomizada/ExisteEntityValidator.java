package br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.ValidacaoCustomizada;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExisteEntityValidator implements ConstraintValidator<ExisteEntity,Object>{

    private String domainAttribute;
    private Class<?> klass;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(ExisteEntity params){
        this.domainAttribute = params.fieldName();
        this.klass=params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
       
        String qlString = "select 1 from "+ this.klass.getName() +" where "+this.domainAttribute+"=:id";
        Query query = this.entityManager.createQuery(qlString);
        query.setParameter("id", value);
        List<?> list = query.getResultList();

        if(list.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

}
