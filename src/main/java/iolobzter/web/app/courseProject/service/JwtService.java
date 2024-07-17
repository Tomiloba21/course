package iolobzter.web.app.courseProject.service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtService {
    /***
     * Secret
     * claim
     * Key
     * xxxx.yyyyy.zzzz
     * //Hidden in application.properties
     * bKMLULwMePV/TeHim2SBt2j/8FRegydBvVvGzxB2hkY=\n
     *
     */

    @Value("${jwt.secret.string}")
    private  String secretString ;

    private Key generateSigningKey(){
        byte[] secretBytes = Decoders.BASE64.decode(secretString);
        return Keys.hmacShaKeyFor(secretBytes);
    }


    public String generateToken(Map<String, Object> claims){
        Date issuedAt = new Date(System.currentTimeMillis());
        Date expiration = new Date(issuedAt.getTime() + 1000 *60 *24);
        return  Jwts
                .builder()
                .setClaims(claims)
                .setIssuedAt(issuedAt)
                .setExpiration(expiration)
                .signWith(generateSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims extractAllClaims(String token){
        return  Jwts
            .parserBuilder()
            .setSigningKey(generateSigningKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
    }
    public Date extractExpiration(String token){
        return extractAllClaims(token).getExpiration();
    }

    public String extractSubject(String token){
        return extractAllClaims(token).getSubject();

    }

    public boolean isTokenValid(String token) {
        return  new Date().before(extractExpiration(token));
    }
}
