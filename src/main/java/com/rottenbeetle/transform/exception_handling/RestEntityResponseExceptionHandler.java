package com.rottenbeetle.transform.exception_handling;

import com.rottenbeetle.transform.model.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@ControllerAdvice
public class RestEntityResponseExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({BadCredentialsException.class, AuthenticationException.class})
    @ResponseBody
    public ResponseEntity<ResponseError> handleAuthenticationException(Exception ex) {
        ResponseError responseError = new ResponseError(
                new Date(),
                HttpStatus.UNAUTHORIZED.value(),
                HttpStatus.UNAUTHORIZED,
                "Authentication failed",
                ex.getMessage());

        return new ResponseEntity<>(responseError, HttpStatus.UNAUTHORIZED);
    }
}