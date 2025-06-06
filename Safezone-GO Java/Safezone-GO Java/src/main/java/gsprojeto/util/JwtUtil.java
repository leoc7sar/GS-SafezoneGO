package gsprojeto.util;

import java.util.Date;

import io.jsonwebtoken.*;

public class JwtUtil {

    private static final String SECRET = "chave-secreta";
    private static final long EXPIRATION = 86400000; // 1 dia

    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    public static String extractUsername(String token) {
        try {
            return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject();
        } catch (JwtException e) {
            return null;
        }
    }

	public static boolean validateToken(String token) {
		// TODO Auto-generated method stub
		return false;
	}
}
