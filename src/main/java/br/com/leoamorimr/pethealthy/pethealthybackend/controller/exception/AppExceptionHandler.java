package br.com.leoamorimr.pethealthy.pethealthybackend.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.leoamorimr.pethealthy.pethealthybackend.service.exception.DataIntegrityException;
import br.com.leoamorimr.pethealthy.pethealthybackend.service.exception.ObjectNotFoundException;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	StandardError err;

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {
		err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	/*
	 * @ExceptionHandler(MethodArgumentNotValidException.class) public
	 * ResponseEntity<StandardError> dataIntegrity(MethodArgumentNotValidException
	 * e, HttpServletRequest request) { ValidationError err = new
	 * ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação",
	 * System.currentTimeMillis());
	 * 
	 * for (FieldError x : e.getBindingResult().getFieldErrors()) {
	 * err.addError(x.getField(), x.getDefaultMessage()); }
	 * 
	 * return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err); }
	 */
}
