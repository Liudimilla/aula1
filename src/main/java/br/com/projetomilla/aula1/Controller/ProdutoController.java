package br.com.projetomilla.aula1.Controller;

import br.com.projetomilla.aula1.entidade.Produto;
import br.com.projetomilla.aula1.repositorio.ProdutoRepositorio;
import org.springframework.stereotype.Controller;

@Controller
public class ProdutoController {
    ProdutoRepositorio produtoRepositorio;
    public void salvar(Produto produto){

        produtoRepositorio.save(produto);
    }
    public void deletar(Produto produto){
        produtoRepositorio.delete(produto);
    }
    public void alterar(Produto produto){
         produtoRepositorio.save(produto);
    }
    public void listar(){
        produtoRepositorio.findAll();
    }
}
