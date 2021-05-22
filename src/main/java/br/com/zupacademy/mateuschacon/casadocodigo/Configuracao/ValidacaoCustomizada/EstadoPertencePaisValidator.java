package br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.ValidacaoCustomizada;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCliente.Dtos.NovoClienteRequest;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroPais.Models.Pais;

public class EstadoPertencePaisValidator implements ConstraintValidator<EstadoPertencePais,NovoClienteRequest>{

    private Class<?> domainClass;
    private String fildName;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(EstadoPertencePais constraintAnnotation) {
        this.domainClass = constraintAnnotation.domainClass();
        this.fildName = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(NovoClienteRequest value, ConstraintValidatorContext context) {
        
        if(value.getIdentificadorEstado() == null){ return true; }
        if(!this.isValidEstadoEntity(this.domainClass, this.fildName, value.getIdentificadorEstado())){return false;}

        String qlString = "select m.pais from "+this.domainClass.getName()+" m where m."+this.fildName+"="+value.getIdentificadorEstado();
        Query query = this.entityManager.createQuery(qlString);

        Pais pais = (Pais) query.getSingleResult();
        
        if( pais.getId().equals(value.getIdentificadorPais())){
            return true;
        }

        return false;
        
    }

    private boolean isValidEstadoEntity(Class<?>klass, String domainAttribute, Long value){

        String qlString = "select 1 from "+ klass.getName() +" where "+domainAttribute+"="+value;
        Query query = this.entityManager.createQuery(qlString);
        List<?> list = query.getResultList();

        if(list.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
    
}
