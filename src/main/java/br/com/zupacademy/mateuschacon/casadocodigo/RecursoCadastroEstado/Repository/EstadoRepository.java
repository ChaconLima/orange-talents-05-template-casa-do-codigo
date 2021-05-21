package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroEstado.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroEstado.Models.Estado;

@Repository
public interface EstadoRepository  extends CrudRepository<Estado,Long>{
    
}
