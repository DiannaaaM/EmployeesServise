package com.example.employees;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeStorageIsFullException extends Throwable{
    public EmployeeStorageIsFullException(String errorMessage) {
        super(errorMessage);
    }

}