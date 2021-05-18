package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Repositorys;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Models.Autor;

@Repository
public interface AutorRepository  extends CrudRepository<Autor,UUID>{

    Optional<Autor> findByEmail(String email);
    
}
