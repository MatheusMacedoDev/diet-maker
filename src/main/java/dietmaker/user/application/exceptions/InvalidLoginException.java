package dietmaker.user.application.exceptions;

public class InvalidLoginException extends RuntimeException {

    public InvalidLoginException() {
        super("E-mail or password invalid, please check again");
    }

}
