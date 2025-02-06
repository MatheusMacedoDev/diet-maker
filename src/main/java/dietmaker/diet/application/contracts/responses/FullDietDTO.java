package dietmaker.diet.application.contracts.responses;

import java.util.List;

import dietmaker.diet.domain.valueobjects.Macronutrients;

public record FullDietDTO(String dietName, Macronutrients macronutrients, List<MealDTO> meals) {
}
