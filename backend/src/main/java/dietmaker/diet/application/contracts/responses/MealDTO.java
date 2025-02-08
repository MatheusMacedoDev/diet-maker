package dietmaker.diet.application.contracts.responses;

import java.util.List;
import java.util.UUID;

import dietmaker.diet.domain.entities.Meal;
import dietmaker.diet.domain.valueobjects.Macronutrients;

public record MealDTO(UUID mealId, String mealName, Macronutrients macronutrients, List<MealDishDTO> dishes,
    List<MealFoodDTO> foods) {

    public MealDTO(Meal meal) {
        this(
            meal.getMealId(),
            meal.getMealName(),
            meal.getMacronutrients(),
            meal.getMealDishes().stream().map(MealDishDTO::new).toList(),
            meal.getMealFoods().stream().map(MealFoodDTO::new).toList());
    }
}
