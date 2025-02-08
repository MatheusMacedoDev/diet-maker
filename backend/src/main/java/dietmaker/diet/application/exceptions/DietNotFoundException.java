package dietmaker.diet.application.exceptions;

public class DietNotFoundException extends RuntimeException {

    public DietNotFoundException() {
        super("Diet with this id not found");
    }

}
