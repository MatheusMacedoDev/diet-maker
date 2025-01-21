package dietmaker.user.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dietmaker.user.application.contracts.requests.UserRequestDTO;
import dietmaker.user.domain.entities.User;
import dietmaker.user.domain.repositories.UserRepository;
import dietmaker.user.utils.cryptography.CryptographyStrategy;

@Service
public class UserService {

    @Autowired
    private CryptographyStrategy cryptographyStrategy;

    @Autowired
    private UserRepository userRepository;

    public void createUser(UserRequestDTO request) {
        byte[] passwordSalt = cryptographyStrategy.generateSalt();
        byte[] passwordHash = cryptographyStrategy.hashPassword(request.password(), passwordSalt);

        User user = new User(
                request.userName(),
                request.email(),
                passwordHash,
                passwordSalt,
                request.weight(),
                request.activityLevelCoefficient());

        userRepository.save(user);
    }
}
