package dietmaker.diet.application.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dietmaker.diet.application.contracts.requests.DietRequestDTO;
import dietmaker.diet.domain.entities.Diet;
import dietmaker.diet.domain.repositories.DietRepository;
import dietmaker.user.application.exceptions.UserNotFoundException;
import dietmaker.user.domain.entities.User;
import dietmaker.user.domain.repositories.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class DietService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DietRepository dietRepository;

    @Transactional
    public void createDiet(DietRequestDTO dietRequest) {
        User user = getUserById(dietRequest.userId());
        Diet diet = new Diet(dietRequest.dietName(), user);

        dietRepository.save(diet);
    }

    private User getUserById(UUID userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (!userOptional.isPresent())
            throw new UserNotFoundException();

        return userOptional.get();
    }

}
