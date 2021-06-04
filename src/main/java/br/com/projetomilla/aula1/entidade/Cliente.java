package br.com.projetomilla.aula1.entidade;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {
    @Id
    private Integer id;
    private String nome;
    private String endereco;
    private String cpf;
    private String telefone;
}

