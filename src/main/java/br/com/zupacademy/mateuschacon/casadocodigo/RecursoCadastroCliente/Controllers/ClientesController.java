package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCliente.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCliente.Dtos.IdClienteResponse;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCliente.Dtos.NovoClienteRequest;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCliente.Models.Cliente;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroCliente.Repositorys.ClienteRepository;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroEstado.Repository.EstadoRepository;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroPais.Repository.PaisRepository;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClientesController {
    
    @Autowired
    PaisRepository  paisRepository;
    @Autowired
    EstadoRepository estadoRepository;
    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<?> cadastroCliente(@RequestBody @Valid NovoClienteRequest novoClienteRequest){

        Cliente cliente =  novoClienteRequest.toModel(estadoRepository, paisRepository);
        this.clienteRepository.save(cliente);

        IdClienteResponse idClienteResponse = new IdClienteResponse(cliente.getId(), cliente.toString());
        
        return ResponseEntity.ok(idClienteResponse);
    }

}
