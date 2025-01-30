package dietmaker.diet.application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dietmaker.diet.application.contracts.requests.DietRequestDTO;
import dietmaker.diet.application.contracts.requests.DishDTO;
import dietmaker.diet.application.contracts.requests.FoodDTO;
import dietmaker.diet.application.contracts.responses.DietDTO;
import dietmaker.diet.application.exceptions.DishNotFoundException;
import dietmaker.diet.application.exceptions.FoodNotFoundException;
import dietmaker.diet.domain.entities.Diet;
import dietmaker.diet.domain.entities.DietDish;
import dietmaker.diet.domain.entities.DietFood;
import dietmaker.diet.domain.entities.Dish;
import dietmaker.diet.domain.entities.Food;
import dietmaker.diet.domain.repositories.DietDishRepository;
import dietmaker.diet.domain.repositories.DietFoodRepository;
import dietmaker.diet.domain.repositories.DietRepository;
import dietmaker.diet.domain.repositories.DishRepository;
import dietmaker.diet.domain.repositories.FoodRepository;
import dietmaker.diet.domain.valueobjects.Macronutrients;
import dietmaker.user.application.exceptions.UserNotFoundException;
import dietmaker.user.domain.entities.User;
import dietmaker.user.domain.repositories.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class DietService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private DietRepository dietRepository;

    @Autowired
    private DietFoodRepository dietFoodRepository;

    @Autowired
    private DietDishRepository dietDishRepository;

    @Transactional
    public void createDiet(DietRequestDTO dietRequest) {
        User user = getUserById(dietRequest.userId());

        Diet diet = new Diet(dietRequest.dietName(), user);

        List<DietFood> dietFoods = mapDietFoods(dietRequest.dietFoods(), diet);
        List<DietDish> dietDishes = mapDietDishes(dietRequest.dietDishes(), diet);

        Macronutrients dietMacronutrients = Macronutrients.calculateDietMacronutrients(dietFoods, dietDishes);
        diet.setMacronutrients(dietMacronutrients);

        dietRepository.save(diet);
        dietFoodRepository.saveAll(dietFoods);
        dietDishRepository.saveAll(dietDishes);
    }

    private User getUserById(UUID userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (!userOptional.isPresent())
            throw new UserNotFoundException();

        return userOptional.get();
    }

    private List<DietFood> mapDietFoods(FoodDTO[] foodDTOs, Diet diet) {
        List<DietFood> dietFoods = new ArrayList<DietFood>();

        byte dietFoodsQuantity = (byte) foodDTOs.length;

        for (byte dietFoodIndex = 0; dietFoodIndex < dietFoodsQuantity; dietFoodIndex++) {
            var unmappedDietFood = foodDTOs[dietFoodIndex];

            Optional<Food> foodOptional = foodRepository.findById(unmappedDietFood.foodId());

            if (!foodOptional.isPresent())
                throw new FoodNotFoundException();

            Food food = foodOptional.get();

            short foodGrams = unmappedDietFood.gramsQuantity();

            var mappedDietFood = new DietFood(diet, food, foodGrams);

            dietFoods.add(mappedDietFood);
        }

        return dietFoods;
    }

    private List<DietDish> mapDietDishes(DishDTO[] dishDTOs, Diet diet) {
        List<DietDish> dietDishes = new ArrayList<DietDish>();

        byte dietDishesQuantity = (byte) dishDTOs.length;

        for (byte dietDishIndex = 0; dietDishIndex < dietDishesQuantity; dietDishIndex++) {
            var unmappedDietDish = dishDTOs[dietDishIndex];

            Optional<Dish> dishOptional = dishRepository.findById(unmappedDietDish.dishId());

            if (!dishOptional.isPresent())
                throw new DishNotFoundException();

            Dish dish = dishOptional.get();

            float multiplier = unmappedDietDish.multiplier();

            var mappedDietDish = new DietDish(diet, dish, multiplier);

            dietDishes.add(mappedDietDish);
        }

        return dietDishes;
    }

    public List<DietDTO> listDietsByUserId(UUID userId) {
        User user = getUserById(userId);

        List<Diet> unmappedUserDiets = dietRepository.findAllByUser(user);
        List<DietDTO> mappedUserDiets = unmappedUserDiets.stream().map(DietDTO::new).toList();

        return mappedUserDiets;
    }
}
