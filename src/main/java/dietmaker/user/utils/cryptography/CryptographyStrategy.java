package dietmaker.user.utils.cryptography;

public interface CryptographyStrategy {
    byte[] generateSalt();

    byte[] hashPassword(String passwordText, byte[] salt);
}
