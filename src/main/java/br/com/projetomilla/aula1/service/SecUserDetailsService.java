package br.com.projetomilla.aula1.service;

import br.com.projetomilla.aula1.entidade.Cliente;
import br.com.projetomilla.aula1.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SecUserDetailsService implements UserDetailsService {
    @Autowired
    ClienteRepositorio clienteRepositorio;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Cliente cliente = clienteRepositorio.findByEmail(s);
        if(cliente == null){
            throw new UsernameNotFoundException(s);
        }else{
            UserDetails details = new SecUserDetails(cliente);
            return details;
        }

    }
}
