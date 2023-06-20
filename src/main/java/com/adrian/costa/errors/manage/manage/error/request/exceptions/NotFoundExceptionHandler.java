package com.adrian.costa.errors.manage.manage.error.request.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.adrian.costa.errors.manage.manage.error.request.exceptions.config.ExceptionConfig;

@EnableWebMvc
@ControllerAdvice
// @Order(Ordered.HIGHEST_PRECEDENCE)
public class NotFoundExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    protected ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionConfig exceptionConfig = new ExceptionConfig();
        return exceptionConfig.getExceptionResponse(ex,request, status);
    }

}
