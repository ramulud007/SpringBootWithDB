package com.jbk.GlobalException;

import java.util.HashMap;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public HashMap<String, String> MethodArgumentNotvalidException(MethodArgumentNotValidException ex) {

		HashMap<String, String> map = new HashMap<>();

		BindingResult bindingResult = ex.getBindingResult();

		List<FieldError> fieldErrors = bindingResult.getFieldErrors();

		for (FieldError fieldError : fieldErrors) {
			map.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return map;
	}

	@ExceptionHandler(ProductAlreadyExistsException.class)
	public String ProductAlreadyExitsException(ProductAlreadyExistsException ex) {
		return ex.getMessage();
	}

	@ExceptionHandler(ProductNotExistsException.class)
	public String ProductNotExistsException(ProductNotExistsException ex) {
		return ex.getMessage();
	}

	@ExceptionHandler(ProductAlreadyUpdated.class)
	public String ProductAlreadyUpdated(ProductAlreadyUpdated ex) {
		return ex.getMessage();
		
	}
	
	@ExceptionHandler(ProductUpdateDoneSuccessfully.class)
	public String ProductUpdateDoneSuccessfully(ProductUpdateDoneSuccessfully ex) {
		return ex.getMessage();
		
	}
	
	@ExceptionHandler(ProductAddedSuccessfully.class)
	public String ProductAddedSuccessfully(ProductAddedSuccessfully ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(TotalCountOfProducts.class)
	public String TotalCountOfProducts(TotalCountOfProducts ex) {
		return ex.getMessage();
	}
}
