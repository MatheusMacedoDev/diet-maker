package dietmaker.diet.application.contracts.responses;

import dietmaker.diet.domain.entities.MealDish;
import dietmaker.diet.domain.valueobjects.Macronutrients;

public record MealDishDTO(short dishId, String name, Macronutrients macronutrients, float multiplier) {
    public MealDishDTO(MealDish mealDish) {
        this(mealDish.getDish().getDishId(), mealDish.getDish().getDishName(), mealDish.getDish().getMacronutrients(),
            mealDish.getMultiplier());
    }
}
