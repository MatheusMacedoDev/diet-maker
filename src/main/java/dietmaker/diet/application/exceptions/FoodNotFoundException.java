package dietmaker.diet.application.exceptions;

public class FoodNotFoundException extends RuntimeException {

    public FoodNotFoundException() {
        super("Food with this id not found");
    }

}
