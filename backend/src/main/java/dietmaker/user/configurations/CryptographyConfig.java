package dietmaker.user.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dietmaker.user.infra.security.cryptography.Argon2idCryptographyStrategy;
import dietmaker.user.infra.security.cryptography.CryptographyStrategy;

@Configuration
public class CryptographyConfig {

    @Bean
    public CryptographyStrategy cryptographyStrategy() {
        return new Argon2idCryptographyStrategy();
    }
}
