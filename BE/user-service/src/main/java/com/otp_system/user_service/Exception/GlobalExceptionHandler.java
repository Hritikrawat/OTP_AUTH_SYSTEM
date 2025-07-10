package com.otp_system.user_service.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


        @ExceptionHandler(UserNotFoundException.class)
        public ResponseEntity<String> hanlderUserNotFound(UserNotFoundException userNotFoundException)
        {
                return new ResponseEntity<>(userNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        }

}
