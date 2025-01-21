package com.app.foodapp.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

/*
 * Estructura de un token que va a ser generado
 * */
@Component
public class JwtUtil {

    // secretKey = jwt.secret del archivo application.properties
    @Value("${jwt.secret}")
    private String secretKey;

    // fecha de caducidad
    //recomendado 30min-1h. No se puede poner un valor más alto
    // a no ser que sea un proyecto personal
    @Value("${jwt.expiration}")
    private Long expirationTime;

    // Para que nadie pueda saber la clave privada la decodificamos.
    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(this.secretKey));
    }

    /*
     * JWT: Librería de seguridad de tokens
     * setSubject: Aquí añadimos los elementos que enviemos en el token
     * setIssuedAt: Fecha de creación del token
     * setExpiration: cuando caduca el token. Se selecciona la fecha actual en milisegundos y se suma la fecha expiración
     * signWith: Firma con la clave privada
     * compact: para generar el token público
     * */
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + this.expirationTime))
                .signWith(this.getSigningKey())
                .compact();
    }

    // verificamos que mi token privado coincida con el token de la solicitud que llega
    public boolean validateToken(String token) {
        try {
            JwtParser parser = Jwts.parser()
                    .setSigningKey(getSigningKey())
                    .build();
            parser.parseClaimsJws(token);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public String extractEmail(String token) {
        JwtParser parser = Jwts.parser()
                .setSigningKey(this.getSigningKey())
                .build();
        Claims claims = parser.parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

}
