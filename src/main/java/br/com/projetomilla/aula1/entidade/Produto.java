package br.com.projetomilla.aula1.entidade;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Produto {
    private String nome;
    @Id
    private Integer id;
    private String descricao;
    private int quantidade;
    private float preco;
}
