package com.souvanny.demojpa.handler;

import com.souvanny.demojpa.dto.ErrorDto;
import com.souvanny.demojpa.dto.InvalidEntityErrorDto;
import com.souvanny.demojpa.exception.EntityToCreateHasAnIdException;
import com.souvanny.demojpa.exception.EntityToUpdateHasNoIdException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @org.springframework.web.bind.annotation.ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto handleEntityNotFound(EntityNotFoundException ex, HttpServletRequest request) {
        return new ErrorDto(ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler({EntityToCreateHasAnIdException.class, EntityToUpdateHasNoIdException.class})
    @org.springframework.web.bind.annotation.ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleEntityValidation(RuntimeException ex, HttpServletRequest request) {
        return new ErrorDto(ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @org.springframework.web.bind.annotation.ResponseStatus(HttpStatus.BAD_REQUEST)
    public InvalidEntityErrorDto handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
        BindingResult bindingResult = ex.getBindingResult();

        List<String> globalErrors = bindingResult.getGlobalErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());

        List<String> fieldErrors = bindingResult.getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());

        return new InvalidEntityErrorDto(
                "Validation échouée.",
                request.getRequestURI(),
                globalErrors,
                fieldErrors
        );
    }
}
