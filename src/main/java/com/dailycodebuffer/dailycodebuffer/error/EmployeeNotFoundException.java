package com.dailycodebuffer.dailycodebuffer.error;



public class EmployeeNotFoundException  extends  RuntimeException{
    public EmployeeNotFoundException(String message){
        super(message);
    }
}
