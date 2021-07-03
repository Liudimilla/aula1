package br.com.projetomilla.aula1.repositorio;

import br.com.projetomilla.aula1.entidade.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio
    extends JpaRepository<Cliente, Integer>{
    @Query("select c from Cliente c where email= :email")
    Cliente findByEmail(@Param("email") String email);
}
