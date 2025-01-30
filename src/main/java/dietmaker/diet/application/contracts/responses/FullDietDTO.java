package dietmaker.diet.application.contracts.responses;

import java.util.List;
import java.util.UUID;

import dietmaker.diet.domain.entities.Diet;
import dietmaker.diet.domain.valueobjects.Macronutrients;

public record FullDietDTO(UUID dietId, String dietName, Macronutrients macronutrients, List<DietDishDTO> dishes,
    List<DietFoodDTO> foods) {

    public FullDietDTO(Diet diet, List<DietDishDTO> dishes, List<DietFoodDTO> foods) {
        this(diet.getDietId(), diet.getDietName(), diet.getMacronutrients(), dishes, foods);
    }
}
