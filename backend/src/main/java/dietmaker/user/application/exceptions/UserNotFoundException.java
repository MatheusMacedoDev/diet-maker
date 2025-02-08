package dietmaker.user.application.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("User with this id not found");
    }

}
