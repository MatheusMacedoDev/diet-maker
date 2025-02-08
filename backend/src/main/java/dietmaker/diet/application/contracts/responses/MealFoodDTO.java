package dietmaker.diet.application.contracts.responses;

import dietmaker.diet.domain.entities.MealFood;
import dietmaker.diet.domain.valueobjects.Macronutrients;

public record MealFoodDTO(short foodId, String name, Macronutrients macronutrients, short gramsQuantity) {
    public MealFoodDTO(MealFood mealFood) {
        this(mealFood.getFood().getFoodId(), mealFood.getFood().getFoodName(), mealFood.getFood().getMacronutrients(),
            mealFood.getGramsQuantity());
    }
}
