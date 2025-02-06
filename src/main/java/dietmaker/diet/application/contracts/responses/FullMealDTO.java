package dietmaker.diet.application.contracts.responses;

import java.util.List;
import java.util.UUID;

import dietmaker.diet.domain.entities.Meal;
import dietmaker.diet.domain.valueobjects.Macronutrients;

public record FullMealDTO(UUID mealId, String dietName, Macronutrients macronutrients, List<DietDishDTO> dishes,
    List<DietFoodDTO> foods) {

    public FullMealDTO(Meal meal, List<DietDishDTO> dishes, List<DietFoodDTO> foods) {
        this(meal.getMealId(), meal.getMealName(), meal.getMacronutrients(), dishes, foods);
    }
}
