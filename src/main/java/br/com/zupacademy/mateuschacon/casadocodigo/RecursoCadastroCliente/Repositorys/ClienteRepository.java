package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCliente.Repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCliente.Models.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente,Long>{
    
}
