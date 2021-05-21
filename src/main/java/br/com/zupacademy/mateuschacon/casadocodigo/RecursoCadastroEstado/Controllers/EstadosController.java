package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroEstado.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroEstado.Dtos.NovoEstadoRequest;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroEstado.Models.Estado;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroEstado.Repository.EstadoRepository;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroPais.Repository.PaisRepository;

@RestController
@RequestMapping(value = "/api/estados")
public class EstadosController {
    
    @Autowired
    PaisRepository paisRepository;
    
    @Autowired
    EstadoRepository estadoRepository;

    @PostMapping
    public String cadastroEstado(@RequestBody @Valid NovoEstadoRequest novoEstadoRequest){

        Estado estado = novoEstadoRequest.toModel(paisRepository);
        this.estadoRepository.save(estado);

        return estado.toString();
    }
}
