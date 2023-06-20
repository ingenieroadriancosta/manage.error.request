package com.adrian.costa.errors.manage.manage.error.request.exceptions.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.adrian.costa.errors.manage.manage.error.request.responses.ErrorDTO;
import com.adrian.costa.errors.manage.manage.error.request.responses.ServerResponse;

import java.net.http.HttpHeaders;
import java.time.LocalDateTime;

@RestControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity<Object> catchBadRequestResponse(Exception ex, WebRequest request) {
        return getExceptionResponse(ex,request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Object> catchRequiredRequestParameter(Exception ex, WebRequest request) {
        return getExceptionResponse(ex,request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> catchInternalServerError(Exception ex, WebRequest request) {
        return getExceptionResponse(ex,request, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    
    @ExceptionHandler(NotFoundErrorException.class)
    public ResponseEntity<Object> catchNotFoundError(Exception ex, WebRequest request) {
        return getExceptionResponse(ex,request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<Object> catchServletRequestParameterPropertyValues(Exception ex, WebRequest request) {
        return getExceptionResponse(ex,request, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return getExceptionResponse(ex,request, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> getExceptionResponse(Exception ex, WebRequest request, HttpStatus httpStatus) {
        ErrorDTO dto = new ErrorDTO(
                LocalDateTime.now().toString(),
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                request.getDescription(false));
        return ResponseEntity.status(httpStatus).body(new ServerResponse(dto).getResponse());
    }

}
