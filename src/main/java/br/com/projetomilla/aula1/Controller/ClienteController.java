package br.com.projetomilla.aula1.Controller;

import br.com.projetomilla.aula1.entidade.Cliente;
import br.com.projetomilla.aula1.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {
@Autowired
    ClienteRepositorio clienteRepositorio;
@PostMapping("cliente")
    public void salvar(Cliente cliente){
     clienteRepositorio.save(cliente);
    }
    @DeleteMapping("cliente")
    public void deletar(Cliente cliente){
        clienteRepositorio.delete(cliente);

    }
    @PutMapping("cliente")
    public void alterar(Cliente cliente){
        clienteRepositorio.save(cliente);
    }
    @GetMapping("cliente")
    public void listar(){
             clienteRepositorio.findAll();
    }
}
