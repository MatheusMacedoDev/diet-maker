package dietmaker.diet.application.contracts.responses;

import dietmaker.diet.domain.entities.Dish;
import dietmaker.diet.domain.valueobjects.Macronutrients;

public record DishDTO(short dishId, String name, Macronutrients macronutrients) {
    public DishDTO(Dish dish) {
        this(dish.getDishId(), dish.getDishName(), dish.getMacronutrients());
    }
}
