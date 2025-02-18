package com.santosh.InventoryManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CompanyExceptionHandler {

	@ExceptionHandler(value = {CompanyNotFoundException.class})
    public ResponseEntity<Object> handleCompanyNotFoundException
            (CompanyNotFoundException companyNotFoundException)
    {
        CompanyException companyException = new CompanyException(
                companyNotFoundException.getMessage(),
                companyNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(companyException, HttpStatus.NOT_FOUND);
    }
	
}
