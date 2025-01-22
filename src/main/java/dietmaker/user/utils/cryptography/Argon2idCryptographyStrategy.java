package dietmaker.user.utils.cryptography;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;

import org.bouncycastle.crypto.generators.Argon2BytesGenerator;
import org.bouncycastle.crypto.params.Argon2Parameters;

public class Argon2idCryptographyStrategy implements CryptographyStrategy {
    private static final int MEMORY = 65536;
    private static final int ITERATIONS = 2;
    private static final int PARALLELISM = 1;

    private static final int HASH_LENGTH = 32;
    private static final int SALT_LENGHT = 16;

    private final SecureRandom secureRandom;

    public Argon2idCryptographyStrategy() {
        this.secureRandom = new SecureRandom();
    }

    public byte[] generateSalt() {
        byte[] salt = new byte[SALT_LENGHT];
        secureRandom.nextBytes(salt);
        return salt;
    }

    public byte[] hashPassword(String passwordText, byte[] salt) {
        byte[] hashedPassword = new byte[HASH_LENGTH];

        Argon2Parameters.Builder argonBuilder = new Argon2Parameters.Builder(Argon2Parameters.ARGON2_id)
                .withVersion(Argon2Parameters.ARGON2_VERSION_13)
                .withMemoryAsKB(MEMORY)
                .withIterations(ITERATIONS)
                .withParallelism(PARALLELISM)
                .withSalt(salt);

        Argon2BytesGenerator argonGenerator = new Argon2BytesGenerator();
        argonGenerator.init(argonBuilder.build());

        argonGenerator.generateBytes(passwordText.getBytes(StandardCharsets.UTF_8), hashedPassword);

        return hashedPassword;
    }

    @Override
    public boolean passwordMatches(String passwordText, byte[] passwordSalt, byte[] passwordHash) {
        byte[] hashedTestPassword = hashPassword(passwordText, passwordSalt);
        return Arrays.equals(passwordHash, hashedTestPassword);
    }
}
