package br.com.projetomilla.aula1.seguranca;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

public class TokenAuthenticationService {
    static final long VALIDADE_TOKEN = 60000;
    static final String PASSE = "milla";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";
    static void adicionarautenticaçao (HttpServletResponse response, String nickname){
        Date expiracao = new Date(System.currentTimeMillis()+ VALIDADE_TOKEN); //pega o tempo atual da maquina
      String jwt = Jwts.builder()
              .setSubject(nickname)
              .setExpiration(expiracao)
              .signWith(SignatureAlgorithm.HS512, PASSE)
              .compact();
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + jwt);

        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        response.addHeader("Authorization_Expiration",dateFormat.format(expiracao));

    }
    static Authentication buscaAutenticacao (HttpServletRequest request){
        //public Authentication buscaAuthentication
        String Token = request.getHeader(HEADER_STRING);
        if (Token!= null){
            String cliente = Jwts.parser()
                    .setSigningKey(PASSE)
                    .parseClaimsJws(Token.replace(TOKEN_PREFIX, ""))//criptograf a informaçao
                    .getBody()
                    .getSubject();
            if (cliente!= null) {
                return new UsernamePasswordAuthenticationToken(cliente, null, Collections.emptyList());
            }
        }
        return null;
        }

    }




