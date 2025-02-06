package dietmaker.diet.application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dietmaker.diet.application.contracts.requests.DishRequestDTO;
import dietmaker.diet.application.contracts.responses.DishDTO;
import dietmaker.diet.application.exceptions.FoodNotFoundException;
import dietmaker.diet.domain.entities.Dish;
import dietmaker.diet.domain.entities.DishFood;
import dietmaker.diet.domain.entities.Food;
import dietmaker.diet.domain.repositories.DishFoodRepository;
import dietmaker.diet.domain.repositories.DishRepository;
import dietmaker.diet.domain.repositories.FoodRepository;
import dietmaker.diet.domain.valueobjects.Macronutrients;
import jakarta.transaction.Transactional;

@Service
public class DishService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private DishFoodRepository dishFoodRepository;

    @Transactional
    public void createDish(DishRequestDTO dishRequest) {
        Dish dish = new Dish(dishRequest.dishName());

        byte dishFoodsQuantity = (byte) dishRequest.dishFoods().length;
        List<DishFood> dishFoods = new ArrayList<DishFood>();

        double dishCarbohydrates = 0;
        double dishProtein = 0;
        double dishLipids = 0;
        double dishFibers = 0;

        for (byte dishFoodIndex = 0; dishFoodIndex < dishFoodsQuantity; dishFoodIndex++) {
            var unmappedDishFood = dishRequest.dishFoods()[dishFoodIndex];

            Optional<Food> foodOptional = foodRepository.findById(unmappedDishFood.foodId());

            if (!foodOptional.isPresent())
                throw new FoodNotFoundException();

            Food food = foodOptional.get();

            short foodGrams = unmappedDishFood.gramsQuantity();

            dishCarbohydrates += food.getMacronutrients().getCarbohydrates() * foodGrams;
            dishProtein += food.getMacronutrients().getProtein() * foodGrams;
            dishLipids += food.getMacronutrients().getLipids() * foodGrams;
            dishFibers += food.getMacronutrients().getFibers() * foodGrams;

            var mappedDishFood = new DishFood(dish, food, foodGrams);

            dishFoods.add(mappedDishFood);
        }

        dish.setMacronutrients(new Macronutrients(dishCarbohydrates, dishProtein, dishLipids, dishFibers));

        dishRepository.save(dish);
        dishFoodRepository.saveAll(dishFoods);
    }

    public List<DishDTO> findDishesByName(String name) {
        List<Dish> unmappedDishes = dishRepository.findAllDishesByNameSimilarity(name);
        List<DishDTO> mappedDishes = unmappedDishes.stream().map(DishDTO::new).toList();

        return mappedDishes;
    }
}
