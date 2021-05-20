package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroLivro.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroLivro.Models.Livro;

@Repository
public interface LivroRepository extends CrudRepository< Livro,Long>{
    
}
