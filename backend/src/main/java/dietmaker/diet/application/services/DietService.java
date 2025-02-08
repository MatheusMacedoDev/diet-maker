package dietmaker.diet.application.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dietmaker.diet.application.contracts.requests.DietRequestDTO;
import dietmaker.diet.application.contracts.responses.DietDTO;
import dietmaker.diet.application.contracts.responses.FullDietDTO;
import dietmaker.diet.application.contracts.responses.MealDTO;
import dietmaker.diet.application.exceptions.DietNotFoundException;
import dietmaker.diet.domain.entities.Diet;
import dietmaker.diet.domain.entities.Meal;
import dietmaker.diet.domain.repositories.DietRepository;
import dietmaker.diet.domain.repositories.MealRepository;
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

    @Autowired
    private MealRepository mealRepository;

    @Transactional
    public void createDiet(DietRequestDTO dietRequest) {
        User user = getUserById(dietRequest.userId());
        Diet diet = new Diet(dietRequest.dietName(), user, dietRequest.dietWaterMl());

        dietRepository.save(diet);
    }

    private User getUserById(UUID userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (!userOptional.isPresent())
            throw new UserNotFoundException();

        return userOptional.get();
    }

    public List<DietDTO> listDietsByUserId(UUID userId) {
        User user = getUserById(userId);

        List<Diet> unmappedUserDiets = dietRepository.findAllByUser(user);
        List<DietDTO> mappedUserDiets = unmappedUserDiets.stream().map(DietDTO::new).toList();

        return mappedUserDiets;
    }

    public FullDietDTO getDietById(UUID dietId) {
        Optional<Diet> dietOptional = dietRepository.findById(dietId);

        if (!dietOptional.isPresent())
            throw new DietNotFoundException();

        Diet diet = dietOptional.get();

        List<Meal> unformattedMeals = mealRepository.findAllByDiet(diet);
        List<MealDTO> formattedMeals = unformattedMeals
            .stream()
            .map(MealDTO::new)
            .toList();

        FullDietDTO mappedDiet = new FullDietDTO(diet.getDietName(), diet.getMacronutrients(), formattedMeals);

        return mappedDiet;
    }
}
