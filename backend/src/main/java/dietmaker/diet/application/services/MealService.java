package dietmaker.diet.application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dietmaker.diet.application.contracts.requests.MealRequestDTO;
import dietmaker.diet.application.contracts.requests.PostDishDTO;
import dietmaker.diet.application.contracts.requests.PostFoodDTO;
import dietmaker.diet.application.exceptions.DietNotFoundException;
import dietmaker.diet.application.exceptions.DishNotFoundException;
import dietmaker.diet.application.exceptions.FoodNotFoundException;
import dietmaker.diet.domain.entities.Diet;
import dietmaker.diet.domain.entities.MealDish;
import dietmaker.diet.domain.entities.MealFood;
import dietmaker.diet.domain.entities.Dish;
import dietmaker.diet.domain.entities.Food;
import dietmaker.diet.domain.entities.Meal;
import dietmaker.diet.domain.repositories.MealDishRepository;
import dietmaker.diet.domain.repositories.MealFoodRepository;
import dietmaker.diet.domain.repositories.MealRepository;
import dietmaker.diet.domain.repositories.DietRepository;
import dietmaker.diet.domain.repositories.DishRepository;
import dietmaker.diet.domain.repositories.FoodRepository;
import dietmaker.diet.domain.valueobjects.Macronutrients;
import jakarta.transaction.Transactional;

@Service
public class MealService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private DietRepository dietRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private MealFoodRepository mealFoodRepository;

    @Autowired
    private MealDishRepository mealDishRepository;

    @Transactional
    public void createMeal(MealRequestDTO mealRequest) {
        Diet diet = getDietById(mealRequest.dietId());

        Meal meal = new Meal(mealRequest.mealName(), diet);

        List<MealFood> mealFoods = mapDietFoods(mealRequest.mealFoods(), meal);
        List<MealDish> mealDishes = mapDietDishes(mealRequest.mealDishes(), meal);

        Macronutrients mealMacronutrients = Macronutrients.calculateMealMacronutrients(mealFoods, mealDishes);
        meal.setMacronutrients(mealMacronutrients);

        diet.setMacronutrients(
            diet.getMacronutrients()
                .plus(mealMacronutrients));

        mealRepository.save(meal);
        mealFoodRepository.saveAll(mealFoods);
        mealDishRepository.saveAll(mealDishes);
    }

    private Diet getDietById(UUID dietId) {
        Optional<Diet> dietOptional = dietRepository.findById(dietId);

        if (!dietOptional.isPresent())
            throw new DietNotFoundException();

        return dietOptional.get();
    }

    private List<MealFood> mapDietFoods(PostFoodDTO[] foodDTOs, Meal meal) {
        List<MealFood> dietFoods = new ArrayList<MealFood>();

        byte dietFoodsQuantity = (byte) foodDTOs.length;

        for (byte dietFoodIndex = 0; dietFoodIndex < dietFoodsQuantity; dietFoodIndex++) {
            var unmappedDietFood = foodDTOs[dietFoodIndex];

            Optional<Food> foodOptional = foodRepository.findById(unmappedDietFood.foodId());

            if (!foodOptional.isPresent())
                throw new FoodNotFoundException();

            Food food = foodOptional.get();

            short foodGrams = unmappedDietFood.gramsQuantity();

            var mappedDietFood = new MealFood(meal, food, foodGrams);

            dietFoods.add(mappedDietFood);
        }

        return dietFoods;
    }

    private List<MealDish> mapDietDishes(PostDishDTO[] dishDTOs, Meal meal) {
        List<MealDish> dietDishes = new ArrayList<MealDish>();

        byte dietDishesQuantity = (byte) dishDTOs.length;

        for (byte dietDishIndex = 0; dietDishIndex < dietDishesQuantity; dietDishIndex++) {
            var unmappedDietDish = dishDTOs[dietDishIndex];

            Optional<Dish> dishOptional = dishRepository.findById(unmappedDietDish.dishId());

            if (!dishOptional.isPresent())
                throw new DishNotFoundException();

            Dish dish = dishOptional.get();

            float multiplier = unmappedDietDish.multiplier();

            var mappedDietDish = new MealDish(meal, dish, multiplier);

            dietDishes.add(mappedDietDish);
        }

        return dietDishes;
    }

}
