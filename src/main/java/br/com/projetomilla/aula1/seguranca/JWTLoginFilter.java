package br.com.projetomilla.aula1.seguranca;

import br.com.projetomilla.aula1.entidade.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

    protected JWTLoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {

        Cliente credentials = new ObjectMapper().readValue(request.getInputStream(), Cliente.class);

        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
                credentials.getEmail(), credentials.getSenha(), Collections.emptyList()));
    } // busca se o cliente existe, tem authenticar em caso de sucesso cria o jwt token

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain filterChain, Authentication auth) throws IOException, ServletException {
        TokenAuthenticationService.adicionarautenticaçao(response, auth.getName());
    }
}
