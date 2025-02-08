package dietmaker.diet.application.contracts.requests;

import java.util.UUID;

public record MealRequestDTO(String mealName, UUID dietId, PostFoodDTO[] mealFoods, PostDishDTO[] mealDishes) {
}
