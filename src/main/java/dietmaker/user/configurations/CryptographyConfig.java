package dietmaker.user.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dietmaker.user.utils.cryptography.Argon2idCryptographyStrategy;
import dietmaker.user.utils.cryptography.CryptographyStrategy;

@Configuration
public class CryptographyConfig {

    @Bean
    public CryptographyStrategy cryptographyStrategy() {
        return new Argon2idCryptographyStrategy();
    }
}
