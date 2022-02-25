package com.spring.demospring.handler;

import org.hibernate.PropertyValueException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spring.demospring.dto.ResponseModel;
import com.spring.demospring.service.exception.UserException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<ResponseModel> handleCustomException(
    		PropertyValueException exception
    ) {
        ResponseModel resp = new ResponseModel();
        resp.setCode(98);
        resp.setMessage(exception.getMessage());
        return new ResponseEntity<ResponseModel>(resp, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ResponseModel> handleCustomException(
    		DataIntegrityViolationException exception
    ) {
        ResponseModel resp = new ResponseModel();
        resp.setCode(98);
        resp.setMessage(exception.getMessage());
        return new ResponseEntity<ResponseModel>(resp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ResponseModel> handleInputErrorException(
            MissingRequestHeaderException exception
    ) {
        ResponseModel resp = new ResponseModel();
        resp.setCode(99);
        resp.setMessage("Error: input parameters not found.");
        return new ResponseEntity<ResponseModel>(resp, HttpStatus.NOT_FOUND);
    }
}
