
package com.servprod.apptcc.controllers.exception;


import com.servprod.apptcc.service.exceptions.AuthorizationException;
import com.servprod.apptcc.service.exceptions.DataIntegrityException;
import com.servprod.apptcc.service.exceptions.FileException;
import com.servprod.apptcc.service.exceptions.ObjectNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
//
    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {

        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Integridade de dados", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
//
//    @ExceptionHandler(EmptyResultDataAccessException.class)
//    public ResponseEntity<StandardError> emptyResultDataAccessException(EmptyResultDataAccessException e, HttpServletRequest request) {
//
//        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Integridade de dados", e.getMessage(), request.getRequestURI());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
//
//        ValidationError err = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de validação", e.getMessage(), request.getRequestURI());
//        for (FieldError x : e.getBindingResult().getFieldErrors()) {
//            err.addError(x.getField(), x.getDefaultMessage());
//        }
//        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
//    }
//
    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<StandardError> authorization(AuthorizationException e, HttpServletRequest request) {

        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.FORBIDDEN.value(), "Acesso negado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardError> httpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request) {
        String message = e.getMessage();
        if(message.contains("YearOfEra") || message.contains("MonthOfYear") || message.contains("DayOfMonth")) {
            message = "Data inválida";
        }
        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Bad Request", message, request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
//
//    @ExceptionHandler(FileException.class)
//    public ResponseEntity<StandardError> file(FileException e, HttpServletRequest request) {
//
//        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro de arquivo", e.getMessage(), request.getRequestURI());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
//    }
}
