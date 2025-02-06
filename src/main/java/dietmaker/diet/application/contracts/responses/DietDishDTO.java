package dietmaker.diet.application.contracts.responses;

import dietmaker.diet.domain.entities.MealDish;
import dietmaker.diet.domain.valueobjects.Macronutrients;

public record DietDishDTO(short dishId, String name, Macronutrients macronutrients, float multiplier) {
    public DietDishDTO(MealDish dietDish) {
        this(dietDish.getDish().getDishId(), dietDish.getDish().getDishName(), dietDish.getDish().getMacronutrients(),
            dietDish.getMultiplier());
    }
}
