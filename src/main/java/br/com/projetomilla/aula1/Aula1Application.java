package br.com.projetomilla.aula1;

import br.com.projetomilla.aula1.entidade.Cliente;
import br.com.projetomilla.aula1.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Aula1Application {


	public static void main(String[] args) {
		SpringApplication.run(Aula1Application.class, args);


	}

}
