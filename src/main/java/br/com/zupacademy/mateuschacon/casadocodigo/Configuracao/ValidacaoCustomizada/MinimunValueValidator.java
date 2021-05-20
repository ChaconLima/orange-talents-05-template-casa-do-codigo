package br.com.zupacademy.mateuschacon.casadocodigo.Configuracao.ValidacaoCustomizada;

import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinimunValueValidator implements ConstraintValidator<MinimumValue,Object>{

    private BigDecimal number;

    @Override
    public void initialize(MinimumValue params){
        this.number = new BigDecimal(params.minimun());
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        
        BigDecimal valorConvertido = new BigDecimal(value.toString());

        if(valorConvertido.doubleValue() >= this.number.doubleValue()){
            return true;
        }else{
            return false;
        }
 
    }
    
}
