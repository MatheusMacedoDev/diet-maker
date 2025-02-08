package dietmaker.user.application.exceptions.handler;

import org.springframework.http.HttpStatus;

public record ExceptionMessage(HttpStatus status, String message) {
}
