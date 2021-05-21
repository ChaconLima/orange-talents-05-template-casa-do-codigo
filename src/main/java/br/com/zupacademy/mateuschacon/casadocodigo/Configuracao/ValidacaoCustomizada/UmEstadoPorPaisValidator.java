package br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.ValidacaoCustomizada;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroEstado.Dtos.NovoEstadoRequest;

public class UmEstadoPorPaisValidator implements ConstraintValidator<UmEstadoPorPais,NovoEstadoRequest>{
    
    private String fildName;
    private Class<?> domainClass;


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UmEstadoPorPais constraintAnnotation) {
        this.fildName=constraintAnnotation.fieldName();
        this.domainClass = constraintAnnotation.domainClass();

    }

    @Override
    public boolean isValid(NovoEstadoRequest value, ConstraintValidatorContext context) {
        
        String qlString = "select m.nome from "+this.domainClass.getName()+" m left join m."+this.fildName+" p where m."+this.fildName+"="+value.getIdentificadorPais();
        Query query = this.entityManager.createQuery(qlString);
   
        List<?> list = query.getResultList();

        /*A solução não é tão agradável,
        * porém entendi que um pais não pode ter estados repetitidos
        * com o mesmo nome. Então busco todos os nomes de estados
        * que estão vinculados com o identificador do país que veio na requisição,
        * e verifico se o nome do estado que veio na requisição para cadastrar 
        * está na presente essa lista.
        * Caso sim -> signifca que o nome que veio na requisição já está vinculado com 
        * com o idetificador do país informado, então retorno de erro de validação;
        * Caso não -> signifca que o nome que veio na requisição não está vinculado com 
        * identificador do país informado, premisão para persistir os dados;
        */
        for (Object object : list) {
            if( object.toString().equals(value.getNome())){
                return false;
            }
        }
        return true;
    }
    
}
