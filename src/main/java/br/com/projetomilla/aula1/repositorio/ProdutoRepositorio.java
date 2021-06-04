package br.com.projetomilla.aula1.repositorio;

import br.com.projetomilla.aula1.entidade.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorio
    extends JpaRepository<Produto, Integer> {
}
