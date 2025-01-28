package dietmaker.diet.application.contracts.requests;

public record DishRequestDTO(String dishName, FoodDTO[] dishFoods) {
}
