package dietmaker.diet.application.exceptions;

public class DishNotFoundException extends RuntimeException {

    public DishNotFoundException() {
        super("Dish with this id not found");
    }

}
