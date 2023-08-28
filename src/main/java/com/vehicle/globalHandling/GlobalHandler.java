package com.vehicle.globalHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vehicle.customException.BrandNotFoundException;
import com.vehicle.customException.IdNotFoundException;
import com.vehicle.customException.InvalidBoardException;

@RestControllerAdvice
public class GlobalHandler {
	@ExceptionHandler(BrandNotFoundException.class)
	public ResponseEntity<Object> brandHandling() {
		return new ResponseEntity<>("Sorry brand doesn't found",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(InvalidBoardException.class)
	public ResponseEntity<Object> boardHandling() {
		return new ResponseEntity<>("Board Mismatched",HttpStatus.BAD_REQUEST);
	}
//	@ExceptionHandler(IdNotFoundException.class)
//	public String idHandling(){
//		return  "Id not found";
//	}
}
