package com.dailycodebuffer.dailycodebuffer.error;

import com.dailycodebuffer.dailycodebuffer.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestResponceEntityExceptionHandler  extends RestResponseEntityExceptionHandler{


    //function name employeeNotFoundHandler


    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage employeeNotFoundHandler(EmployeeNotFoundException employeeNotFoundException){
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, employeeNotFoundException.getMessage());
        return errorMessage;
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage genericExceptionHandler(Exception exception){
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return errorMessage;
    }

}
