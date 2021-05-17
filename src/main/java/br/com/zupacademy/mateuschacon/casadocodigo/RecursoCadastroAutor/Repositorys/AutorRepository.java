package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Repositorys;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroAutor.Models.Autor;

public interface AutorRepository  extends CrudRepository<Autor,UUID>{
    
}
