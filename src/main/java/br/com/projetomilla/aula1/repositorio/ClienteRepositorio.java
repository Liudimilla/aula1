package br.com.projetomilla.aula1.repositorio;

import br.com.projetomilla.aula1.entidade.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio
    extends JpaRepository<Cliente, Integer>{
    public Cliente findByEmail(String email);
}
