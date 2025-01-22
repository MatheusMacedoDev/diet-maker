package dietmaker.user.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import dietmaker.user.domain.entities.User;

@Service
public class TokenService {

    @Value("${JWT_SECRET}")
    private String jwtSectret;

    public String generateToken(User user) {
        try {

        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while generating token", exception);
        }
        Algorithm algorithm = Algorithm.HMAC256(jwtSectret);

        String token = JWT.create()
                .withIssuer("diet-maker-api")
                .withSubject(user.getEmail())
                .withExpiresAt(generateExpirationDate())
                .sign(algorithm);

        return token;
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(jwtSectret);
            return JWT.require(algorithm)
                    .withIssuer("diet-maker-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return "";
        }
    }

    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
