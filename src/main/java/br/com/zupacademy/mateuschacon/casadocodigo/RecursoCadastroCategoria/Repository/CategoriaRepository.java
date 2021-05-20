package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCategoria.Repository;

import java.util.Optional;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCategoria.Models.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria,Long>{

    Optional <Categoria> findByNome(String nome);
    
}
