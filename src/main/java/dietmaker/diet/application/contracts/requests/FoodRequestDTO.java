package dietmaker.diet.application.contracts.requests;

public record FoodRequestDTO(String name, double carbohydrates, double protein, double lipids, double fibers) {
}
