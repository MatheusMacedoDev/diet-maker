package dietmaker.diet.application.contracts.requests;

import java.util.UUID;

public record DietRequestDTO(String dietName, UUID userId, FoodDTO[] dietFoods, DishDTO[] dietDishes) {
}
