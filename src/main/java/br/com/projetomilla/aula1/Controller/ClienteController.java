package br.com.projetomilla.aula1.Controller;

import br.com.projetomilla.aula1.entidade.Cliente;
import br.com.projetomilla.aula1.repositorio.ClienteRepositorio;
import org.springframework.stereotype.Controller;

@Controller
public class ClienteController {
    ClienteRepositorio clienteRepositorio;

    public void salvar(Cliente cliente){
     clienteRepositorio.save(cliente);
    }
    public void deletar(Cliente cliente){
        clienteRepositorio.delete(cliente);

    }
    public void alterar(Cliente cliente){
        clienteRepositorio.save(cliente);
    }
    public void listar(){
             clienteRepositorio.findAll();
    }
}
