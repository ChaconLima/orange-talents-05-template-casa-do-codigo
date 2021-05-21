package br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroPais.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroPais.Dtos.NovoPaisRequest;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroPais.Models.Pais;
import br.com.zupacademy.mateuschacon.casadocodigo.RecursoCadastroPais.Repository.PaisRepository;

@RestController
@RequestMapping(value = "/api/paises")
public class PaisesController {
    
    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    public String cadastroPais(@RequestBody @Valid NovoPaisRequest novoPaisRequest){

        Pais pais = novoPaisRequest.toModel();
        this.paisRepository.save(pais);

        return pais.toString();
    }
}
