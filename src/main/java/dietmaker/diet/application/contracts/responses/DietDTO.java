package dietmaker.diet.application.contracts.responses;

import java.util.UUID;

import dietmaker.diet.domain.entities.Diet;
import dietmaker.diet.domain.valueobjects.Macronutrients;

public record DietDTO(UUID dietId, String dietName, Macronutrients macronutrients) {
    public DietDTO(Diet diet) {
        this(diet.getDietId(), diet.getDietName(), diet.getMacronutrients());
    }
}
