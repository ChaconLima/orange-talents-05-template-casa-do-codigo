package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCategoria.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCategoria.Models.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria,UUID>{

    Optional <Categoria> findByNome(String nome);
    
}
