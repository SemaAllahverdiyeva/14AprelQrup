
package az.developia.spring_project_14Aprel.util;

import java.security.Key;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private final Key signinKey;

    public JwtUtil(@Value("${jwt.secret}") String secretKey) {
        byte[] decodedKey = Base64.getDecoder().decode(secretKey);
        SecretKey hmacShaKey = Keys.hmacShaKeyFor(decodedKey);
        this.signinKey = hmacShaKey;
    }

    public String generateToken(String username, List<String> authorities) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("authorities", authorities);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000L))
                .signWith(signinKey)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(signinKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public Map<String, Object> extractClaims(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(signinKey)
                .build()
                .parseClaimsJws(token)
                .getBody();

        Map<String, Object> claimMap = new HashMap<>();

        Object authoritiesClaim = claims.get("authorities");

        if (authoritiesClaim instanceof List<?>) {
            List<String> authorities = new ArrayList<>();

            for (Object authority : (List<?>) authoritiesClaim) {
                if (authority instanceof String) {
                    authorities.add((String) authority);
                }
            }

            claimMap.put("authorities", authorities);
        } else if (authoritiesClaim instanceof String) {
            String authorities = (String) authoritiesClaim;

            if (authorities.isBlank()) {
                claimMap.put("authorities", new ArrayList<String>());
            } else {
                claimMap.put("authorities", List.of(authorities.split(",")));
            }
        } else {
            claimMap.put("authorities", new ArrayList<String>());
        }

        return claimMap;
    }
}
