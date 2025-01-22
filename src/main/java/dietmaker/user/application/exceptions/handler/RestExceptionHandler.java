package dietmaker.user.application.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import dietmaker.user.application.exceptions.InvalidLoginException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidLoginException.class)
    private ResponseEntity<ExceptionMessage> handleInvalidLoginException(InvalidLoginException exception) {
        return handleRuntimeException(exception, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ExceptionMessage> handleRuntimeException(RuntimeException exception, HttpStatus status) {
        ExceptionMessage message = new ExceptionMessage(status, exception.getMessage());
        return ResponseEntity.status(status).body(message);
    }
}
