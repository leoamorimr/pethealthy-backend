package br.com.leoamorimr.pethealthy.pethealthybackend.controller.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

   @ExceptionHandler(Exception.class)
   public ResponseEntity<Object> handleAnyException(Exception e, WebRequest request) {
      String errorDescription = e.getLocalizedMessage();
      if (errorDescription == null)
         errorDescription = e.toString();
      ErrorDetail errorDetail = new ErrorDetail(LocalDateTime.now(), errorDescription);
      return new ResponseEntity<>(errorDetail, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
   }
}
