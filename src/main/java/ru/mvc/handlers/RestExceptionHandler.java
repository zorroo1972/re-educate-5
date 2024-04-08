package ru.mvc.handlers;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import ru.mvc.exceptions.ErrorMessage;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                ex.getMessage()
);

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }

}

