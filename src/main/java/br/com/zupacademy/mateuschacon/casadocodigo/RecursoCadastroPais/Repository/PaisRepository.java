package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroPais.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroPais.Models.Pais;

@Repository
public interface PaisRepository extends CrudRepository<Pais,Long>{
    
}
