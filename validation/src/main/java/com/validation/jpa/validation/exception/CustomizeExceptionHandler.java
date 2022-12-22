package com.validation.jpa.validation.exception;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class CustomizeExceptionHandler  extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorDetails> handleConstraintViolationException(
	  HttpServletRequest request, ConstraintViolationException ex
	) {
		ErrorDetails error=new ErrorDetails(LocalDate.now(),ex.getMessage(),"bad request");
	 return new ResponseEntity<ErrorDetails>(error,HttpStatus.NOT_FOUND);
	}
	
//	@ExceptionHandler(Exception.class)
//	public final ResponseEntity<ErrorDetails> handleAllException(Exception ex,WebRequest request){
//		
//		ErrorDetails error=new ErrorDetails(LocalDate.now(),ex.getMessage(),request.getDescription(false));
//		
//		return new ResponseEntity<ErrorDetails>(error,HttpStatus.BAD_REQUEST);
//	}
//	@ExceptionHandler(ConstraintViolationException.class)
//	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex,WebRequest request){
//		
//		ErrorDetails error=new ErrorDetails(LocalDate.now(),ex.getMessage(),request.getDescription(false));
//		
//		return new ResponseEntity<ErrorDetails>(error,HttpStatus.NOT_FOUND);
//	}
//	
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(
//			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//		ErrorDetails error=new ErrorDetails(LocalDate.now(),ex.getMessage(),request.getDescription(false));
//		return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
//		
//	}
}
