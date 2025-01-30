package dietmaker.diet.application.contracts.responses;

import dietmaker.diet.domain.entities.DietFood;
import dietmaker.diet.domain.valueobjects.Macronutrients;

public record DietFoodDTO(short foodId, String name, Macronutrients macronutrients, short gramsQuantity) {
    public DietFoodDTO(DietFood dietFood) {
        this(dietFood.getFood().getFoodId(), dietFood.getFood().getFoodName(), dietFood.getFood().getMacronutrients(),
            dietFood.getGramsQuantity());
    }
}
