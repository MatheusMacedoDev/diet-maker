package dietmaker.diet.application.exceptions.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import dietmaker.diet.application.exceptions.DishNotFoundException;
import dietmaker.diet.application.exceptions.FoodNotFoundException;
import dietmaker.user.application.exceptions.UserNotFoundException;

@ControllerAdvice
public class DietRestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(FoodNotFoundException.class)
    private ResponseEntity<ExceptionMessage> handleFoodNotFoundException(FoodNotFoundException exception) {
        return handleRuntimeException(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DishNotFoundException.class)
    private ResponseEntity<ExceptionMessage> handleDishNotFoundException(DishNotFoundException exception) {
        return handleRuntimeException(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<ExceptionMessage> handleUserNotFoundException(UserNotFoundException exception) {
        return handleRuntimeException(exception, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<ExceptionMessage> handleRuntimeException(RuntimeException exception, HttpStatus status) {
        ExceptionMessage message = new ExceptionMessage(status, exception.getMessage());
        return ResponseEntity.status(status).body(message);
    }
}
